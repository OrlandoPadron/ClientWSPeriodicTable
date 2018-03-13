/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwsperiodictable;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author orlan
 */
//Método para devolver todos los elementos de la tabla periódica. 
@Root
public class NewDataSet {
    
    @ElementList(entry="Table", inline=true)
    private List<Table> tabla;

    public List<Table> getTabla(){
        return tabla; 
    }
  



    
    



    
    
}
