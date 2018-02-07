package com.ca.works.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ca.works.crud.Employee;
import com.ca.works.crud.GenericResponse;
import com.ca.works.restejb.CustomerDAO;
import com.ca.works.restejb.UtilDAO;

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeServiceImpl implements EmployeeService {

	// @EJB
	private EmployeeDAO employeeDao;
	private static Map<Integer, Employee> emps = new HashMap<Integer, Employee>();

	
	@POST
	@Path("/add")
	public Response addEmployee(Employee e) {
		GenericResponse response = new GenericResponse();
		if (emps.get(e.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Employee Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		emps.put(e.getId(), e);
		response.setStatus(true);
		response.setMessage("Employee created successfully");
		return Response.ok(response).build();
	}

	@POST
	@Path("/adddb")
	public Response addEmployeeDb(Employee e) {
		GenericResponse response = new GenericResponse();
		employeeDao = UtilDAO.lookup(EmployeeDAO.class);
		employeeDao.add(e);
		response.setStatus(true);
		response.setMessage("Employee created successfully");
		return Response.ok(response).build();
	}
	
	@DELETE
	@Path("/{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		if (emps.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Employee Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		emps.remove(id);
		response.setStatus(true);
		response.setMessage("Employee deleted successfully");
		return Response.ok(response).build();
	}
	
	@DELETE
	@Path("/{id}/deleteDb")
	public Response deleteEmployeeDb(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		employeeDao = UtilDAO.lookup(EmployeeDAO.class);
		Employee emp = employeeDao.findById(id);
		if ( emp == null) {
			response.setStatus(false);
			response.setMessage("Employee Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		employeeDao.remove(emp);
		response.setStatus(true);
		response.setMessage("Employee deleted successfully");
		return Response.ok(response).build();
	}

	
	@GET
	@Path("/{id}/get")
	public Employee getEmployee(@PathParam("id") int id) {
		return emps.get(id);
	}

	@GET
	@Path("/{id}/getdb")
	public Employee getEmployeeDb(@PathParam("id") int id) {
		employeeDao = (EmployeeDAO)UtilDAO.lookup(EmployeeDAO.class);
		return employeeDao.findById(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Employee getDummyEmployee(@PathParam("id") int id) {
		Employee e = new Employee();
		e.setSalary(8976.55);
		e.setName("Dummy");
		e.setId(id);
		return e;
	}

	
	@GET
	@Path("/getAll")
	public Employee[] getAllEmployees() {
		
		Set<Integer> ids = emps.keySet();
		Employee[] e = new Employee[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			e[i] = emps.get(id);
			i++;
		}
		return e;
		
		/*employeeDao = (EmployeeDAO)UtilDAO.lookup(EmployeeDAO.class);
		List<Employee> el =  employeeDao.getAll();
		return (Employee[])el.toArray();*/
	}
	
	@GET
	@Path("/getAllDb")
	@Produces({ "application/json" })
	public List<Employee> getAllEmployeesDb() {		
		employeeDao = (EmployeeDAO)UtilDAO.lookup(EmployeeDAO.class);
		return employeeDao.getAll();
	
	}
	
	
	@PUT
	@Path("/update")
	public Response updateEmployee(Employee e) {
		GenericResponse response = new GenericResponse();
		if (emps.get(e.getId()) == null) {
			response.setStatus(false);
			response.setMessage("Employee does not  Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		emps.put(e.getId(), e);
		response.setStatus(true);
		response.setMessage("Employee updated successfully");
		return Response.ok(response).build();
	}
	
	@PUT
	@Path("/updateDb")
	public Response updateEmployeeDb(Employee e) {
		GenericResponse response = new GenericResponse();
		employeeDao = UtilDAO.lookup(EmployeeDAO.class);
		
		if (employeeDao.update(e) == null) {
			response.setStatus(false);
			response.setMessage("Employee does not  Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		response.setStatus(true);
		response.setMessage("Employee updated successfully");
		return Response.ok(response).build();
	}

}
