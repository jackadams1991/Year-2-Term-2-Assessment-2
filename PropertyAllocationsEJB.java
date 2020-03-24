/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Property Allocation bean class
 */
package assignment3;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class PropertyAllocationsEJB {
    
    @PersistenceContext(unitName = "Assignment_3PU")
    private EntityManager em;

    public PropertyAllocations createPropertyAllocation(PropertyAllocations propertyAllocation)
    {
        em.persist(propertyAllocation);
        return propertyAllocation;
    }
    //Query Methods
    public List<PropertyAllocations> findPropertyAllocations()
    {
        Query query = em.createNamedQuery("findAllAllocations", PropertyAllocations.class);
        return query.getResultList();
    }
    public List<PropertyAllocations> findAPropertyAllocation(long id)
    {
        Query query = em.createNamedQuery("findAllocationByID", PropertyAllocations.class).setParameter("id", id);
        return query.getResultList();
    }
    public List<SaleProperty> findSaleProperties()
    {
        Query query = em.createNamedQuery("findAllSalesProperties", SaleProperty.class);
        return query.getResultList();
    }
    public List<RentalProperty> findRentalProperties()
    {
        Query query = em.createNamedQuery("findAllRentalProperties", RentalProperty.class);
        return query.getResultList();
    }
    public List<PropertyManager> findPropertyManagers()
    {
        Query query = em.createNamedQuery("findAllManagers", PropertyManager.class);
        return query.getResultList();
    }
}
