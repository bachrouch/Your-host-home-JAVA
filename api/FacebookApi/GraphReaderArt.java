/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.FacebookApi;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.esprit.util.MyConnection;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.Url;
import com.restfb.types.User;

/**
 *
 * @author myriam
 */
@SuppressWarnings("deprecation")
public class GraphReaderArt {
     private final FacebookClient facebookClient;
     
     public static void main(String[] args) {
    new GraphReaderArt("").runEverything();
  }

    GraphReaderArt(String accessToken) {
        facebookClient = new DefaultFacebookClient(accessToken);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

  void runEverything() {
      fetchObject();
//    fetchObjects();
//    fetchObjectsAsJsonObject();
//    fetchConnections();
//    fetchDifferentDataTypesAsJsonObject();
//    query();
//    multiquery();
//    search();
//    metadata();
//    paging();
//    selection();
//    parameters();
//    rawJsonResponse();
  }

  void fetchObject() {
    out.println("* Fetching single objects *");

    User user = facebookClient.fetchObject("me", User.class);
    //Page page = facebookClient.fetchObject("cocacola", Page.class);

    out.println("Name: " + user.getName());
    out.println("Username: " + user.getUsername());
    out.println("Email: " + user.getEmail());
    out.println("ID Facebook: " + user.getId());
    out.println("About: " + user.getAbout());
    out.println("Birthday: " + user.getBirthday());
    
    //out.println("Page likes: " + page.getLikes());
  }
}
