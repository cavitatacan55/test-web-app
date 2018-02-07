package com.ca.works.rest;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
 
 
@XmlRootElement(name="listing")
public class ItemList
{
    private List<Item> items;
 
    public ItemList()
    {
    }
 
    public ItemList(List<Item> items)
    {
        this.items = items;
    }
 
    @XmlElement(name="items")
    public List<Item> getItems()
    {
        return items;
    }
}
