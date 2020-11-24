package com.mycompany.new_lab02;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *Object implements JSON functionality
 * @author jakubwawak
 */
public class Parser {
    
    JsonElement data;
    JSONObject json_object;
    JSONArray data_array; 
    
    /**
     * Constructor
     * @param to_parse 
     */
    Parser(JsonElement to_parse){
        data = to_parse;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        json_object = new JSONObject(gson.toJson(data));
        data_array = json_object.getJSONArray("results");
    }
    
    /**
     * Parsing function
     * @return ArrayList
     */
    ArrayList<Movie_Data> parse(){
        ArrayList<Movie_Data> dictionary = new ArrayList<>();
        
        for( int i =0 ; i < get_size(); i++){
            Movie_Data md = new Movie_Data();
            JSONObject jObj = data_array.getJSONObject(i);
            
            try{
                md.title = jObj.getString("title");
            
                md.type = jObj.getString("titleType");
                md.year = jObj.getInt("year");
                
                
                //md.lenght =jObj.getInt("principals");

            }catch(JSONException e){
                System.out.println(e);
            }

            if (!md.blank()){
                dictionary.add(md);
            }
            
            System.out.println(md.show());
        }
        
        
        return dictionary;
    }
    
    /**
     * Function for getting size of the object
     * @return Integer 
     */
    int get_size(){
        return data_array.length();
    }
}
