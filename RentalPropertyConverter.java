/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Converter class for the Rental Property entity
 */
package assignment3;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author Jack
 */
@FacesConverter(forClass = RentalProperty.class)
public class RentalPropertyConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent comp, String propertyId)
    {
        if(propertyId == null || propertyId.equals(""))
        {
            return null;
        }
        
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),"#{propertyController}", PropertyController.class);
        PropertyController prop = (PropertyController)vex.getValue(ctx.getELContext());
        return prop.getRentalProperty(Integer.valueOf(propertyId));
    }
    
    @Override
    public String getAsString(FacesContext ctx, UIComponent comp, Object propertyId)
    {
        if(propertyId == null)
        {
            return "";
        }
        
        if(propertyId instanceof RentalProperty)
        {
            return String.valueOf(((RentalProperty) propertyId).getId());
        }
        return null;
    }
}
