/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Enterprise Bean class for the Property Manager entity
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
public class PropertyManagerEJB {
    
    //Attributes
    @PersistenceContext(unitName = "Assignment_3PU")
    private EntityManager em;
    //Method persists objects into the database
    public PropertyManager createPropertyManager(PropertyManager propertyManager)
    {
        em.persist(propertyManager);
        return propertyManager;
    }
    //Query Methods
    public List<PropertyManager> findAllPropertyManager()
    {
        Query query = em.createNamedQuery("findAllManagers", PropertyManager.class);
        return query.getResultList();
    }
    
    public List<PropertyManager> findPropertyManager(String fName, String lName)
    {
        Query query = em.createNamedQuery("findManager", PropertyManager.class);
        query.setParameter("fName", fName);
        query.setParameter("lName", lName);
        return query.getResultList();
    }
}
