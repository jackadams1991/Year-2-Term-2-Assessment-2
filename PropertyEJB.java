/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Enterprise Bean class for the Property entity
 */
package assignment3;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
/**
 *
 * @author Jack
 */
@Stateless
public class PropertyEJB {

    //Attributes
    @PersistenceContext(unitName = "Assignment_3PU")
    private EntityManager em;
    //Methods used to persist propertties of each type into the database
    public RentalProperty createRentalProperty(RentalProperty property)
    {
        em.persist(property);
        return property;
    }
    public SaleProperty createSaleProperty(SaleProperty property)
    {
        em.persist(property);
        return property;
    }
    //Query methods, called in PropertyController class
    public List<Property> findProperties() //Method is called when properties are created in PropertyController class
    {
        Query query = em.createNamedQuery("findAllProperties", Property.class);
        return query.getResultList();        
    }
    public List<SaleProperty> findAllSaleProperty() //Method called to find all persisted Sale Properties
    {
        Query query = em.createNamedQuery("findAllSalesProperties", SaleProperty.class);
        return query.getResultList();
    }
    public List<RentalProperty> findAllRentalProperty() //Method called to find all persisted Rental Properties
    {
        Query query = em.createNamedQuery("findAllRentalProperties", RentalProperty.class);
        return query.getResultList();
    }
    public List<RentalProperty> findRentalProperty(long id) //Method called when searching for a given Rental Property
    {
        Query query = em.createNamedQuery("findRentalProperty", RentalProperty.class).setParameter("id", id);
        return query.getResultList();
    }
    public List<SaleProperty> findSaleProperty(long id) //Method called when searching for a given Sale Property
    {
        Query query = em.createNamedQuery("findSaleProperty", SaleProperty.class).setParameter("id", id);
        return query.getResultList();
    }
}
