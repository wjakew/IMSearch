
package com.mycompany.new_lab02;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *Object for loading language 
 * @author jakubwawak
 */
public class Language_Loader {
    
    ResourceBundle actual_rb;
    String option;
    
    ArrayList<String> results;
    
    /**
     * Constructor
     * @param option 
     */
    Language_Loader(String option){
        this.option = option;
        results = new ArrayList<>();
        
        actual_rb = load_bundle();
    }
    
    /**
     * Function for loading language data
     * @return ResourceBundle
     */
    ResourceBundle load_bundle(){
        Locale locale = new Locale ("pl","PL");
        try{
            switch(option){            
                case "PL":
                    return ResourceBundle.getBundle("Data");
                case "ENG":
                    return ResourceBundle.getBundle("Data_en_US");
                case "FR":
                    return ResourceBundle.getBundle("Data_fr_FR");
                default:
                    return null;
            }
        
        }catch( Exception e){
            System.out.println("err: "+e.toString());
            return null;
        }
        
    }
    
    /**
     * Function for gathering data from .properties file
     * @param lang_package 
     */
    
    void get_data(){
        
        Enumeration<String> keys = actual_rb.getKeys();
        
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            results.add(actual_rb.getString(key));
        }
        
    }
}
