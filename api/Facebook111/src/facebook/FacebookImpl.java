/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

/**
 *
 * @author Haythem
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookImpl {

    public static void main(String[] args) throws FacebookException {
        // Make the configuration builder 
        ConfigurationBuilder confBuilder = new ConfigurationBuilder();
        confBuilder.setDebugEnabled(true);
// Set application id, secret key and access token 
        confBuilder.setOAuthAppId("524305467737711");
        confBuilder.setOAuthAppSecret("cea5c61e8603b63bd4dbccb71fc2d07b");
        confBuilder.setOAuthAccessToken("4adbdbefa3099d5166d971cbb17731b3");
// Set permission 
        confBuilder.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
        confBuilder.setUseSSL(true);
        confBuilder.setJSONStoreEnabled(true);
// Create configuration object 
        Configuration configuration = confBuilder.build();
// Create facebook instance 
        FacebookFactory ff = new FacebookFactory(configuration);
        Facebook facebook = ff.getInstance();
        try {
// Get facebook posts 
            //String results = getFacebookPostes(facebook);
            //String responce = stringToJson(results); 
// Create file and write to the file 
            User c = getFacebookPostes(facebook);
            System.out.println(c);
            File file = new File("C:\\Users\\Maher\\Desktop\\test.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("aa");
            bw.close();
            System.out.println("Writing complete");
//            User user = getFacebookUser(facebook);
//            System.out.println(user);
        } catch (IOException e) {
// TODO Auto-generated catch block e.printStackTrace(); 
        }
    }
    public static User getFacebookPostes(Facebook facebook) throws FacebookException {
// Get posts for a particular search 
        ResponseList<Post> results = facebook.getPosts("Reebok");
        
        return facebook.getMe();
    }
public static User getFacebookUser(Facebook facebook) throws FacebookException{
   return facebook.getUser("maher");
}
public static String stringToJson(String data) { 
// Create JSON object 
JSONObject jsonObject = JSONObject.fromObject(data); 
JSONArray message = (JSONArray) jsonObject.get("message"); 
System.out.println("Message : "+message); return "Done"; 
}
}
