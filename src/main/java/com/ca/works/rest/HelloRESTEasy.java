package com.ca.works.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;



import com.ca.works.rest.Item;

@Path("/")
public class HelloRESTEasy {

	@GET
	@Path("/sayhello/{param}")
	public Response printMessage(@PathParam("param") String msg) {
		return Response.status(200).entity("Hello  " + msg).build();
	}

	@GET
	@Path("/item")
	@Produces({ "application/xml" })
	public Item getItem() {

		Item item = new Item("computer", 7500);

		return item;
	}

	@GET
	@Path("itemArray")
	@Produces({ "application/xml" })
	public Item[] getItems() {
		Item item[] = new Item[2];
		item[0] = new Item("computer", 2500);
		item[1] = new Item("chair", 100);

		return item;
	}
	
	@GET
	@Path("itemArrayJSON")
	@Produces({ "application/json" })
	public Item[] getItemsJSON() {
		Item item[] = new Item[3];
		item[0] = new Item("computer", 2500);
		item[1] = new Item("chair", 100);
		item[2] = new Item("table", 200);
		return item;
	}

	@GET
	@Path("itemsXML")
	@Produces({ "application/xml" })
	public ItemList getCollItems() {
		ArrayList<Item> list = new ArrayList<Item>();
		Item item1 = new Item("computer", 2500);
		Item item2 = new Item("chair", 100);
		Item item3 = new Item("table", 200);

		list.add(item1);
		list.add(item2);
		list.add(item3);

		return new ItemList(list);
	}
	
	@GET
	@Path("itemsJSON")
	@Produces("application/json")
	public ItemList  getJSONItems() {
	  ArrayList<Item> list = new ArrayList<Item>();
	  Item item1 = new Item("computer",2500);
	  Item item2 = new Item("chair",100);
	  Item item3 = new Item("table",200);
	 
	  list.add(item1);
	  list.add(item2);
	  list.add(item3);
	 
	  return new ItemList(list);
	}  
}
