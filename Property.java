/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.MappedSuperclass;
/**
 *
 * @author Jack
 */
@Entity(name = "PROPERTY")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "property")
@NamedQueries
({
    @NamedQuery(name = "findAllProperties", query = "SELECT p FROM PROPERTY p"),
    @NamedQuery(name = "findSelectedProperty", query = "SELECT p FROM PROPERTY p WHERE p.streetNum LIKE :streetNo AND p.streetName LIKE :streetName")
})
public abstract class Property implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Property_ID")
    private Long id;
    private String type;
    private double numRooms;
    private double numBathrooms;
    private String propertyDesc;
    private int streetNum;
    private String streetName;
    private String city;
    private String postcode;
    private String country;
    
    //Constructor
    public Property()
    {
        //No argument constructor
    }
    public Property(String propType, double rooms, double bathrooms, String desc, int num, String street, String city, String postCode, String country)
    {
        type = propType;
        numRooms = rooms;
        numBathrooms = bathrooms;
        propertyDesc = desc;
        streetNum = num;
        streetName = street;
        this.city = city;
        postcode = postCode;
        this.country = country;
    }
    
    //Setter methods
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public void setNumRooms(double numRooms)
    {
        this.numRooms = numRooms;
    }
    public void setNumBathrooms(double numBathrooms)
    {
        this.numBathrooms = numBathrooms;
    }
    public void setPropertyDesc(String propertyDesc)
    {
        this.propertyDesc = propertyDesc;
    }
    public void setStreetNum(int streetNum)
    {
        this.streetNum = streetNum;
    }
    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setPostcode(String postCode)
    {
        postcode = postCode;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }
    
    //Getter methods
    public Long getId()
    {
        return id;
    }
    public String getType()
    {
        return type;
    }
    public double getNumRooms()
    {
        return numRooms;
    }
    public double getNumBathrooms()
    {
        return numBathrooms;
    }
    public String getPropertyDesc()
    {
        return propertyDesc;
    }
    public int getStreetNum()
    {
        return streetNum;
    }
    public String getStreetName()
    {
        return streetName;
    }
    public String getCity()
    {
        return city;
    }
    public String getPostcode()
    {
        return postcode;
    }
    public String getCountry()
    {
        return country;
    }
    
}
