/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Managed Bean class for the Property Manager entity
 */
package assignment3;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jack
 */
@ManagedBean
@Named(value = "propertyManagerController")
@RequestScoped
public class PropertyManagerController {
    
    @EJB
    private PropertyManagerEJB propertyManagerEJB;
    private PropertyManager propertyManager = new PropertyManager();
    private List<PropertyManager> propertyManagerList = new ArrayList<>();
    private List<PropertyManager> propertyManagerSearchResult = new ArrayList<>();

    /**
     * Creates a new instance of PropertyManagerController
     */
    public PropertyManagerController() {
    }
    
    //Create method for creating a property manager
    public String doCreatePropertyManager()
    {
        propertyManager = propertyManagerEJB.createPropertyManager(propertyManager);
        propertyManagerList = propertyManagerEJB.findAllPropertyManager();
        return "default.xhtml";
    }
    public String createPropertyManager()
    {
        return "newPropertyManager.xhtml";
    }
    //Get methods
    public PropertyManager getPropertyManager(int id)
    {
        for(int i = 0; i < propertyManagerList.size(); i++)
        {
            if(propertyManager.getId().equals(id))
            {
            return propertyManager;
            }
        }
        return null;
    }
    public PropertyManager getPropertyManager()
    {
        return propertyManager;
    }
    public List<PropertyManager> getManagerSearchResult()
    {
        return propertyManagerSearchResult;
    }
    
    //Set methods
    public void setPropertyManager(PropertyManager propertyManager)
    {
       this.propertyManager = propertyManager; 
    }   
    public void setPropertyManagerList(List<PropertyManager> propertyManagerList)
    {
        this.propertyManagerList = propertyManagerList;
    }   
    public void setManagerSearchResult(List<PropertyManager> propertyManagerSearchResult)
    {
        this.propertyManagerSearchResult = propertyManagerSearchResult;
    }
    
    //Method is used to find a given manager in the XHTML page managerSearch
    public String doSearchManager()
    {
        String fName = propertyManager.getFirstName();
        String lName = propertyManager.getLastName();
        propertyManagerSearchResult = propertyManagerEJB.findPropertyManager(fName, lName);
        return "managerSearchResults.xhtml";
    }
    public List<PropertyManager> getPropertyManagerList()
    {
        propertyManagerList = propertyManagerEJB.findAllPropertyManager();
        return(propertyManagerList);
    }
    
}
