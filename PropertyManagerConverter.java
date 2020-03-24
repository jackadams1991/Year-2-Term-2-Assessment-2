/*
- Author: S0201412 - Jack Adams
- Course: COIT13253 - Enterprise Software Development
- Date: 04/10/2019
- Use: Converter class for the Property Manager entity
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
@FacesConverter(forClass = PropertyManager.class)
public class PropertyManagerConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent comp, String managerId)
    {
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),"#{propertyManagerController}", PropertyManagerController.class);
        PropertyManagerController pm = (PropertyManagerController)vex.getValue(ctx.getELContext());
        return pm.getPropertyManager(Integer.valueOf(managerId));
    }
    
    @Override
    public String getAsString(FacesContext ctx, UIComponent comp, Object managerId)
    {
        if(managerId == null)
        {
            return "";
        }
        
        if(managerId instanceof PropertyManager)
        {
            return String.valueOf(((PropertyManager) managerId).getId());
        }
        return null;
    }
}
