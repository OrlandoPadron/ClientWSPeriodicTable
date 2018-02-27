/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwsperiodictable;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.Scanner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


/**
 *
 * @author Orlando Padrón
 */
public class ClientWSPeriodicTable {

    public static void main(String[] args) throws Exception {
        
        int method = 4; 
        String element = "";
        
        //LECTOR 
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Introduzca el método que desee usar \n" + "0. ATOMIC WEIGHT\n" + "1. ATOMIC NUMBER \n"+ "2. GET ATOMS \n" + "3. GET ELEMENT SYMBOL \n");
        
        method = reader.nextInt(); // Scans the next token of the input as an int.
        //once finished

        switch(method){
        //Get AtomicWeight
            case 0: 
                    System.out.println("Introduzca el elemento:");
        
                     // Scans the next token of the input as an int.
                    element = reader.next();
                    String salida = getAtomicWeight(element); 
                    if (!salida.equals("<NewDataSet />")) {
                    String atomicWeight = parseResponse(salida, "</AtomicWeight>");
        
                    System.out.println("El peso atómico de " + element + " es " + atomicWeight);
                    }
                    break; 
            
        //Get AtomicNumber
            case 1: System.out.println("Introduzca el elemento:");
        
                    element = reader.next();
                    String salida2 = getAtomicNumber(element); 
                    
                    if (!salida2.equals("<NewDataSet />")) {
                    String atomicNumber = parseResponse(salida2, "</AtomicNumber>");
                    System.out.println("El número atómico de " + element + " es " + atomicNumber);
                    }
                    
                    break;
            
        //Get Atomos FALLA 
            case 2: 

                    //System.out.println("Átomos"+ getAtoms());
                    //String salida3 = getAtoms(); 
                    
//                    if (!salida3.equals("<NewDataSet />")) {
//                    String atoms = parseResponse(salida3, "</ElementName>");
//                    System.out.println("Elemento: " + atoms);
//                    }

                   System.out.println("NO IMPLEMENTADO\n");
                    
                    
                    
                    
                    
                    break;
                
        //Get ElementsSymbol 
            case 3: 
                    System.out.println("Introduzca el elemento:");
        
                    // Scans the next token of the input as an int.
                    element = reader.next();
                    String salida4 = getElementSymbol(element); 
                    
                    if (!salida4.equals("<NewDataSet />")) {
                    String symbol = parseResponse(salida4, "</Symbol>");
                    System.out.println("El elemento " +element +" tiene el símbolo " + symbol);
                    }
                    
                    break;
                
            default:    System.out.println("Valor inválido");
                        break; 
        }
        
       
        
        
        
    }

    
    //MÉTODOS WEB SERVICE
    private static String getAtomicWeight(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicWeight(elementName);
    }

    private static String getAtomicNumber(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicNumber(elementName);
    }

    private static String getAtoms() {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtoms();
    }

    private static String getElementSymbol(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getElementSymbol(elementName);
    }
    
    private static XStream getXstreamObject() { 
        XStream xstream = new XStream(); 
        return xstream; 
    } 
    
    private static String parseResponse(String response, String endTag) {
        String beginTag = endTag.replace("/", "");
        final int from = response.indexOf(beginTag);
        final int to = response.lastIndexOf(endTag);
        final String beginTagAndContent = response.substring(from, to);
        return beginTagAndContent.substring(beginTagAndContent.indexOf(">") + 1);
    }
    
}
