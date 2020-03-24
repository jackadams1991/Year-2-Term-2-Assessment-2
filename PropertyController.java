/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Managed Bean class for the Property entity
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
@Named(value = "propertyController")
@RequestScoped
public class PropertyController {
    
    @EJB
    private PropertyEJB propertyEJB;
    private Property property;
    private SaleProperty saleProperty = new SaleProperty();
    private RentalProperty rentalProperty = new RentalProperty();
    private List<Property> propertyList = new ArrayList<>();
    private List<SaleProperty> salePropertyList = new ArrayList<>();
    private List<RentalProperty> rentalPropertyList = new ArrayList<>();
    private List<RentalProperty> rentalPropertySearchResult = new ArrayList<>();
    private List<SaleProperty> salePropertySearchResult = new ArrayList<>();
    /**
     * Creates a new instance of PropertyController
     */
    public PropertyController() {
    }
    
    public String doNewSaleProperty()
    {
        return "listSaleProperty.xhtml";
    }
    public String doNewRentalProperty()
    {
        return "listRentalProperty.xhtml";
    }
    public String doCreateSaleProperty()
    {
        saleProperty = propertyEJB.createSaleProperty(saleProperty);
        propertyList = propertyEJB.findProperties();
        return "default.xhtml";
    }
    public String doCreateRentalProperty()
    {
        rentalProperty = propertyEJB.createRentalProperty(rentalProperty);
        propertyList = propertyEJB.findProperties();
        return "default.xhtml";
    }
    
    //Get Methods
    public Property getProperty(int id) //Get method used in converter class
    {
        for(int i = 0; i < propertyList.size(); i++)
        {
            if(property.getId().equals(id))
            {
            return property;
            }
        }
        return null;
    }
    public Property getProperty()
    {
        return property;
    }
    public SaleProperty getSaleProperty(int id) //Get method used in converter class
    {
        for(int i = 0; i < salePropertyList.size(); i++)
        {
            if(saleProperty.getId().equals(id))
            {
            return saleProperty;
            }
        }
        return null;
    }
    public SaleProperty getSaleProperty()
    {
        return saleProperty;
    }
        public RentalProperty getRentalProperty(int id) //Get method used in converter class
    {
        for(int i = 0; i < rentalPropertyList.size(); i++)
        {
            if(rentalProperty.getId().equals(id))
            {
            return rentalProperty;
            }
        }
        return null;
    }
    public RentalProperty getRentalProperty()
    {
        return rentalProperty;
    }
        public List<RentalProperty> getRentalPropertySearchResults()
    {
        return rentalPropertySearchResult;
    }
    public List<SaleProperty> getSalePropertySearchResults()
    {
        return salePropertySearchResult;
    }
    
    //Set methods
    public void setProperty(Property property)
    {
        this.property = property;
    }
    public void setSaleProperty(SaleProperty saleProperty)
    {
        this.saleProperty = saleProperty;
    }
    public void setRentalProperty(RentalProperty rentalProperty)
    {
        this.rentalProperty = rentalProperty;
    }
    public void setAllSalePropertyList(List<SaleProperty> salePropertyList)
    {
        this.salePropertyList = salePropertyList;
    }   
    public void setAllRentalPropertyList(List<RentalProperty> rentalPropertyList)
    {
        this.rentalPropertyList = rentalPropertyList;
    }
    public void setRentalPropertySearchResults(List<RentalProperty> rentalPropertySearchResult)
    {
        this.rentalPropertySearchResult = rentalPropertySearchResult;
    }
    public void setSalePropertySearchResults(List<SaleProperty> salePropertySearchResult)
    {
        this.salePropertySearchResult = salePropertySearchResult;
    }
    
    //Query methods for obtaining all persisted sale and rental properties
    public List<SaleProperty> getAllSalePropertyList()
    {
        salePropertyList = propertyEJB.findAllSaleProperty();
        return salePropertyList;
    }
    public List<RentalProperty> getAllRentalPropertyList()
    {
        rentalPropertyList = propertyEJB.findAllRentalProperty();
        return rentalPropertyList;
    }
    
    //Query methods for searching for a sale or rental property
    public String doSearchSaleProperty()
    {
        long id = saleProperty.getId();
        salePropertySearchResult = propertyEJB.findSaleProperty(id);
        return "saleSearchResults.xhtml";
    }
    public String doSearchRentalProperty()
    {
        long id = rentalProperty.getId();
        rentalPropertySearchResult = propertyEJB.findRentalProperty(id);
        return "rentalSearchResults.xhtml";
    }
}
