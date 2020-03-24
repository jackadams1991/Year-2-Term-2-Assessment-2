/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Entity class for the Sale Property objects
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

/**
 *
 * @author Jack
 */
@Entity
@Table(name = "property")
@NamedQueries
        ({
            @NamedQuery(name = "findAllSalesProperties",query = "SELECT sp FROM SaleProperty sp"),
            @NamedQuery(name = "findSaleProperty", query = "SELECT sp FROM SaleProperty sp WHERE sp.id = :id")
        })
public class SaleProperty extends Property implements Serializable {

    private float salePrice;
    
    //Constructor
    public SaleProperty()
    {
        //No argument constructor
    }
    public SaleProperty(String type, double numRooms, double numBathrooms, String propertyDesc, int streetNum, String streetName, String city, String postcode, String country, float salePrice)
    {
        super(type, numRooms, numBathrooms, propertyDesc, streetNum, streetName, city, postcode, country);
        this.salePrice = salePrice;
    }
    
    //Get and Set methods
    public float getSalePrice()
    {
        return salePrice;
    }
    public void setSalePrice(float salePrice)
    {
        this.salePrice = salePrice;
    }
    
}
