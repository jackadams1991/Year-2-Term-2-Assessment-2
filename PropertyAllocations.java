/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jack
 */
@Entity
@NamedQueries
        ({
            @NamedQuery(name = "findAllAllocations", query = "SELECT a FROM PropertyAllocations a"),
            @NamedQuery(name = "findAllocationByID", query = "SELECT a FROM PropertyAllocations a WHERE a.id = :id")
        })
public class PropertyAllocations implements Serializable {
    
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    @Temporal(TemporalType.TIMESTAMP)
    protected Date timeCreated = new Date();    
    @ManyToOne
    @JoinColumn(name = "PROPERTYID", referencedColumnName = "Property_ID")
    private Property properties;    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PROPERTYMANAGERID", referencedColumnName = "MANAGER_ID")
    private PropertyManager propertyManager;
    
    //Constructors
    public PropertyAllocations()
    {
                
    }
    public PropertyAllocations(Property properties, PropertyManager propertyManager)
    {
        this.properties = properties;
        this.propertyManager = propertyManager;
    }
    
    //Set Methods
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setProperty(Property prop)
    {
        properties = prop;
    }
    public void setManager(PropertyManager pm)
    {
        propertyManager = pm;
    }
    public void setDateCreated(Date d)
    {
        timeCreated = d;
    }
    
    //Get Methods
    public Long getId()
    {
        return id;
    }
    public Property getProperty()
    {
        return properties;
    }
    public PropertyManager getManager()
    {
        return propertyManager;
    }
    public Date getDateCreated()
    {
        return timeCreated;
    }
}
