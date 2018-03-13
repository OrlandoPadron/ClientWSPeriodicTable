/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwsperiodictable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author OrlandoPadrón
 */
@Root(name="Table", strict=false)
public class Table {
    
    @Element(name = "ElementName", required = false)
    public String ElementName; 

    public String getElementName() {
        return ElementName;
    }

    public void setElementName(String ElementName) {
        this.ElementName = ElementName;
    }
    
    
    
    
    
}
