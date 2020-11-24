package com.mycompany.new_lab02;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *Object for setting connection between rest api and application
 * @author jakubwawak
 */
public class Connection {
    String host,charset,x_rapidapi_host,x_rapidapi_key,s,query;
    
    /**
     * Main constructor
     * @param user_token ( "68ec271051msh29bb8b23c243484p1d0efejsn7efe463444ac" )
     * @throws UnsupportedEncodingException 
     */
    Connection (String user_token) throws UnsupportedEncodingException{
      // Host url
      host = "https://imdb8.p.rapidapi.com";
      charset = "UTF-8";
      // Headers for a request
      x_rapidapi_host = "imdb8.p.rapidapi.com";
      x_rapidapi_key = user_token;
      // Params
      s = "Pulp";
      // Format query for preventing encoding problems
      String query = String.format("s=%s",
      URLEncoder.encode(s, charset));
    }
    
    /**
     * Function for finding data in REST
     * @param title
     * @return JsonElement
     * @throws UnirestException 
     */
    JsonElement find_movie(String title) throws UnirestException{
        title = title.replace(" ", "%20");
        HttpResponse <JsonNode> response = Unirest.get("https://imdb8.p.rapidapi.com/title/find?q="+title)
        .header("x-rapidapi-host", x_rapidapi_host)
        .header("x-rapidapi-key", x_rapidapi_key)
        .asJson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        return jp.parse(response.getBody().toString());
    }
    
}
