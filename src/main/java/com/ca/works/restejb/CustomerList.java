package com.ca.works.restejb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ca.works.restejb.Customer;

@XmlRootElement(name="listing")
public class CustomerList {
	
	 private List<Customer> customers;
	 
	    public CustomerList()
	    {
	    }
	 
	    public CustomerList(List<Customer> customers)
	    {
	        this.customers = customers;
	    }
	 
	   
	    
	    @XmlElement(name="customers")
	    public List<Customer> getcustomers()
	    {
	        return customers;
	    }

}
