package com.mycompany.new_lab02;

import java.util.ArrayList;

/**
 *Object for getting data for query
 * @author jakubwawak
 */
public class Data_Ejector {
    
    String data_array;                          // raw data from object
    
    ArrayList<String> data_keys, data_values;   // collection for storing data
    
    
    /**
     * Constructor 
     * @param data 
     */
    Data_Ejector(String data){
        data_array = data;
        data_keys = new ArrayList<String>();
        data_values = new ArrayList<String>();
    }
    
    /**
     * Function for loading and getting data to object
     * @return ArrayList
     */
    ArrayList<String> get_alldata(){
        for(String data_element : data_array.split(",")){
            System.out.println(data_element);
            data_keys.add(data_element.split(":")[0]);
            data_values.add(data_element.split(":")[1]);   
        }
        return null;
    }
    
    /**
     * Function for showing raw data of object
     */
    void show_rawdata(){
        for(String data : data_keys){
            System.out.println(data+":\n"+data_values.get(data_keys.indexOf(data)));
        }
    }

}
