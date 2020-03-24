/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Entity class for the Rental Property objects
 */
package assignment3;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "property")
@NamedQueries
        ({
            @NamedQuery(name = "findAllRentalProperties",query = "SELECT rp FROM RentalProperty rp"),
            @NamedQuery(name = "findRentalProperty", query = "SELECT rp FROM RentalProperty rp WHERE rp.id = :id")
        })
public class RentalProperty extends Property implements Serializable {

    private float rentalPrice;
    private boolean furnished;
    
    //Constructor
    public RentalProperty()
    {
        //No argument constructor
    }
    public RentalProperty(String type, double numRooms, double numBathrooms, String propertyDesc, int streetNum, String streetName, String city, String postcode, String country, float rentalPrice, Boolean furnished)
    {
        super(type, numRooms, numBathrooms, propertyDesc, streetNum, streetName, city, postcode, country);
        this.rentalPrice = rentalPrice;
        this.furnished = furnished;
    }
    
    //Get Methods
    public float getRentalPrice()
    {
        return rentalPrice;
    }
    public boolean getFurnished()
    {
        return furnished;
    }
    //Set methods   
    public void setRentalPrice(float rentalPrice)
    {
        this.rentalPrice = rentalPrice;
    }
    public void setFurnished(boolean furnished)
    {
        this.furnished = furnished;
    }
}
