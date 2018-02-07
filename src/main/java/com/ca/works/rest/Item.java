package com.ca.works.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {
    public Item() {     }
 
    public Item(String description, int price) { 
            this.description = description;
            this.price = price;
    }
  
    private String description;
    private int price;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}