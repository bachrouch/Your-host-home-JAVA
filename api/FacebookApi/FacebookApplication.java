/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.FacebookApi;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

import com.restfb.types.User;
import static java.lang.System.out;

/**
 *
 * @author myriam
 */
public class FacebookApplication {
    /**
     * @param args
     */
    public static void main (String[] args)
    {
      FacebookClient fbClient;
        fbClient = new DefaultFacebookClient("CAACEdEose0cBABom3MQaq7VXGZCHxJWUSplbVeHrWZCMVcZCt7QY4H934T0JhbEsElVmEaq6qDMAWFePsYMlUlQhaqgDZCD6aUJVGMOhvpq28hALspLJkU2SSPzrlDH2qU6eo6HbhPNkI2ZBjWzeL33a5zF3TgCvs5fht22giWICfpcKVmciDfJlUcz1VaahMYBWsg2wJHxlkwJZCwKWZBUZAZBijYXNaNacZD");
      User me=fbClient.fetchObject("1483903805247245",com.restfb.types.User.class);
        System.out.println(me.getName()); 
    }
          
    
}
