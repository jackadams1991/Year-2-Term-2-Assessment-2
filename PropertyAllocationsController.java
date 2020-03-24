/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
/**
 *
 * @author Jack
 */
@ManagedBean
@Named(value = "propertyAllocationsController")
@RequestScoped
public class PropertyAllocationsController {
    
    @EJB
    private PropertyAllocationsEJB propertyAllocationsEJB;
    private PropertyManager propertyManager;
    private Property properties;
    private PropertyAllocations propertyAllocations = new PropertyAllocations();
    private List<PropertyAllocations> propertyAllocationsList = new ArrayList<>();
    private List<PropertyAllocations> propertyAllocationSearchResults = new ArrayList<>();
    private List<PropertyManager> propertyManagerList = new ArrayList<>();
    private List<SaleProperty> salePropertyList = new ArrayList<>();
    private List<RentalProperty> rentalPropertyList = new ArrayList<>();

    @PostConstruct
    public void init() //Method populates lists from the EJB class
    {
        propertyManagerList = propertyAllocationsEJB.findPropertyManagers();
        salePropertyList = propertyAllocationsEJB.findSaleProperties();
        rentalPropertyList = propertyAllocationsEJB.findRentalProperties();
    }
    //Method called to create property allocation
    public String doCreatePropertyAllocation()
    {
        propertyAllocations = propertyAllocationsEJB.createPropertyAllocation(propertyAllocations);
        propertyAllocationsList = propertyAllocationsEJB.findPropertyAllocations();
        return "default.xhtml";
    }
    //Get and Set methods
    public PropertyAllocations getPropertyAllocation()
    {
        return(propertyAllocations);
    }
    public void setPropertyAllocation(PropertyAllocations propertyAllocations)
    {
        this.propertyAllocations = propertyAllocations;
    }
    public List<PropertyAllocations> getPropertyAllocationsList()
    {
        propertyAllocationsList = propertyAllocationsEJB.findPropertyAllocations();
        return(propertyAllocationsList);
    }
    public void setPropertyAllocationsList(List<PropertyAllocations> propertyAllocationsList)
    {
        this.propertyAllocationsList = propertyAllocationsList;
    }
    //Get methods to obtain lists of persisted Managers and Properties, used in newPropertyAllocation.xhtml
    public List<PropertyManager> getPropertyManagerList()
    {
        return propertyManagerList;
    }
    public List<RentalProperty> getRentalPropertyList()
    {
        return rentalPropertyList;
    }
    public List<SaleProperty> getSalePropertyList()
    {
        return salePropertyList;
    }
    //Set and Get methods for PropertyManager and Properties, used in newPropertyAllocation.xhtml
    public void setPropertyManagerList(List<PropertyManager> propertyManagerList)
    {
        this.propertyManagerList = propertyManagerList;
    }
    public void setRentalPropertyList(List<RentalProperty> rentalPropertyList)
    {
        this.rentalPropertyList = rentalPropertyList;
    }
    public void setSalePropertyList(List<SaleProperty> salePropertyList)
    {
        this.salePropertyList = salePropertyList;
    }
    public PropertyManager getPropertyManager()
    {
        return propertyManager;
    }
    public void setPropertyManager(PropertyManager pm)
    {
        propertyManager = pm;
    }
    public Property getProperty()
    {
        return properties;
    }
    public void setProperty(Property properties)
    {
        this.properties = properties;
    }
    //Allocation Search Method + Get and Set methods
    public String doSearchPropertySearch() //Search method, used in allocationSearch.xhtml
    {
        long id = propertyAllocations.getId();
        propertyAllocationSearchResults = propertyAllocationsEJB.findAPropertyAllocation(id);
        return "allocationSearchResults.xhtml";
    }
    public List<PropertyAllocations> getProperyAllocationSearchResults()
    {
        return propertyAllocationSearchResults;
    }
    public void setPropertyAllocationSearchResults(List<PropertyAllocations> propertyAllocationSearchResults)
    {
        this.propertyAllocationSearchResults = propertyAllocationSearchResults;
    }
}
