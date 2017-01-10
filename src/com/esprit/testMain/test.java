/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.testMain;

import com.esprit.dao.OffreDAO;
import com.esprit.dao.UserDAO;
import com.esprit.entities.Offre;
import com.esprit.entities.User;

/**
 *
 * @author maher
 */
public class test {
    public static void main(String[] args) {
        
        
        UserDAO uss = new UserDAO();
        User us = new User();
        
        
        us.setNom("houssem"); us.setPrenom("houssem"); us.setPasswod("houss123");
        us.setTelephone(22113366);us.setEmail("houss@tayech.com"); us.setUsername("houss2");
        us.setRoles("a:1:{i:0;s:14:\"ROLE_ANNONCEUR\";}");
        
        uss.ajouterUser(us);
    }
    
}
