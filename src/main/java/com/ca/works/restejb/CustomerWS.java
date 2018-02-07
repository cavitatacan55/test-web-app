package com.ca.works.restejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/customers")
@Stateless
@LocalBean
public class CustomerWS {

	// @EJB
	private CustomerDAO customersDao;
	private InitialContext ctx;

	@GET
	@Path("/{id}")
	@Produces({ "application/json" })
	public Customer getCustomer(@PathParam("id") int id) {
		
		customersDao = (CustomerDAO)UtilDAO.lookup(CustomerDAO.class);
		return customersDao.getCustomer(id);
	}

	@POST
	public void addCustomers(List<Customer> customers) {
		customersDao =(CustomerDAO)UtilDAO.lookup(CustomerDAO.class);
		customersDao.addCustomers(customers);
	}

	@GET
	@Path("/getAll")
	@Produces({ "application/json" })
	public List<Customer> getAll() {
		customersDao = (CustomerDAO)UtilDAO.lookup(CustomerDAO.class);
		return customersDao.getAll();
	}
}
