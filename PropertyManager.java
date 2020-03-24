/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Property Manager entity class
 */
package assignment3;

//Import statements
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;
import java.util.ArrayList;

@Entity(name = "PROPERTY_MANAGER")
@Table(name = "property_manager")
@NamedQueries
        ({
            @NamedQuery(name = "findAllManagers", query = "SELECT pm FROM PROPERTY_MANAGER pm"),
            @NamedQuery(name = "findManager", query = "SELECT pm FROM PROPERTY_MANAGER pm WHERE pm.firstName = :fName AND pm.lastName = :lName")
        })
public class PropertyManager implements Serializable {

    //Property Manager Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANAGER_ID")
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobilePhoneNumber;
    private String landLinePhoneNumber;
    @OneToMany
    private List<PropertyAllocations> propertyAllocations = new ArrayList<PropertyAllocations>();
    
    //Contstructors
    public PropertyManager()
    {
        
    }
    public PropertyManager(String fName, String lName, String email, String mobile, String phoneNum)
    {
        firstName = fName;
        lastName = lName;
        emailAddress = email;
        mobilePhoneNumber = mobile;
        landLinePhoneNumber = phoneNum;
    }
    
    //Setter Methods
    public void setId(Long managerId)
    {
        id = managerId;
    }
    public void setFirstName(String fName)
    {
        firstName = fName;
    }
    public void setLastName(String lName)
    {
        lastName = lName;
    }
    public void setEmailAddress(String email)
    {
        emailAddress = email;
    }
    public void setMobilePhoneNumber(String mobileNum)
    {
        mobilePhoneNumber = mobileNum;
    }
    public void setLandLinePhoneNumber(String phoneNum)
    {
        landLinePhoneNumber = phoneNum;
    }
    public void setPropertyAllocations(List<PropertyAllocations> propertyAllocations)
    {
        this.propertyAllocations = propertyAllocations;
    }
    
    //Getter Methods
    public Long getId()
    {
        return id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getEmailAddress()
    {
        return emailAddress;
    }
    public String getMobilePhoneNumber()
    {
        return mobilePhoneNumber;
    }
    public String getLandLinePhoneNumber()
    {
        return landLinePhoneNumber;
    }
    public List<PropertyAllocations> getAllocatedProperties()
    {
        return propertyAllocations;
    }
}
