package com.mycompany.new_lab02;

import java.util.ArrayList;

/**
 *Object for movie data gatherd from imdb
 * @author jakubwawak
 */
public class Movie_Data {
    
    String title;
    ArrayList<String> cast;
    int year;
    int lenght;
    String type;
    String url;
    
    /**
     * Constructor
     */
    Movie_Data(){
        title = "";
        cast = new ArrayList<>();
        year = 0;
        lenght = 0;
        type = "";
        url ="";
    }
    
    /**
     * Function for checking if object is empty
     * @return boolean
     */
    boolean blank(){
        return title.isBlank() && year == 0;   
    }
    /**
     * Function for showing raw data of an object
     * @return String
     */
    String show(){
        return "type: "+ type + "\n" + "title: "+title + "\n("+Integer.toString(year)+") time: "+Integer.toString(lenght)+"\n"+show_cast();
    }
    /**
     * Function for showing label of an object
     * @return String
     */
    String label(){
        return title+" ("+type+")";
    }
    
    /**
     * Function for showing cast of the show
     * @return String
     */
    String show_cast(){
        String cast_data = "";
        for(String actor : cast){
            cast_data = cast_data + actor+"\n";
        }
        return cast_data;
    }
    
}
