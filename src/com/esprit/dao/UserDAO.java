/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.esprit.entities.User;
import com.esprit.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Houssem
 */
public class UserDAO {

    Connection cnx;

    public UserDAO() {
        cnx = (Connection) MyConnection.getInstance();
    }

    Statement st = null;

    public void ajouterUser(User u) {
        int a=1;
        int b=0;
        String salt = "icrm78h81y8k0kockokswc0k44gko04";
        String requete = "INSERT INTO fos_user (nom , prenom, telephone, email, roles, username, password, username_canonical, email_canonical, enabled, salt, locked, expired, credentials_expired) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1, u.getNom());
            System.out.println(u.getNom());
            st.setString(2, u.getPrenom());
            System.out.println(u.getPrenom());
            st.setInt(3, u.getTelephone());
            System.out.println(u.getTelephone());
            st.setString(4, u.getEmail());
            System.out.println(u.getEmail());
            st.setString(5, u.getRoles());
            System.out.println(u.getRoles());
            
            st.setString(6, u.getUsername());
            System.out.println(u.getUsername());
            st.setString(7, u.getPasswod()+'{'+salt+'}');
            System.out.println(u.getPasswod()+'{'+salt+'}');
            st.setString(8, u.getUsername());
            st.setString(9, u.getEmail());
            st.setInt(10, a);
            st.setString(11, salt); //////salt
            st.setInt(12, b);
            st.setInt(13, b);
            st.setInt(14, b);
            System.out.println(b);
            st.executeUpdate();
            System.out.println("***********");
            System.out.println("objet ajouté");
        } catch (SQLException ex) {

            System.out.println("objet non ajouté");
        }
    }

   public User findUserByLogin(String login) {
        String requete = "SELECT * FROM `fos_user` WHERE username=?";
        User u = new User();
        try {
           PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(19));
                u.setPrenom(rs.getString(20));
                u.setTelephone(rs.getInt(18));
                u.setEmail(rs.getString(4));
                u.setRoles(rs.getString(15));
                u.setUsername(rs.getString(2));
                u.setPasswod(rs.getString(8));
            }
             return u;
        } catch (SQLException ex) {
            System.err.println("Erreur Recherche1");
            return null;
        }
       
    }

    public boolean checklogin(String l) {
        String requete = "SELECT * FROM `fos_user` WHERE username=?";
        User u = new User();
        try {
           PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, l);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int nbrRow = rs.getRow();
            if (nbrRow == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erreur Recherche2");
            return false;
        }
        
    }

//    public boolean userConnexion(String login, String pwd) {
//        String requete = "SELECT * FROM user where login=" + login;
//        try {
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(requete);
//            rs.last();
//            int nbrRow = rs.getRow();
//            if (nbrRow != 1) {
//                return (checkPassword(pwd));
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.err.println("Erreur Recherche");
//        }
//        return false;
//    }
    public void modifierUser(User u, int id) {

        String requete = "UPDATE fos_user set nom=? , prenom = ? , telephone=? , email=? , password=? where id=" + id;

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            if (u.getNom() != null) {
                pst.setString(1, u.getNom());
            }
            if (u.getPrenom() != null) {
                pst.setString(2, u.getPrenom());
            }
            if (u.getTelephone() != 0) {
                pst.setInt(3, u.getTelephone());
            }
            if (u.getEmail() != null) {
                pst.setString(4, u.getEmail());
            }
            if (u.getPasswod()!= null) {
                pst.setString(5, u.getPasswod());
            }
            pst.executeUpdate();
            System.out.println("modification avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public int findIdUserByLogin(String login){
        int id_user=0;
        User u = null;
        String requete3="SELECT id FROM fos_user WHERE username=?";
        try{
            PreparedStatement st= cnx.prepareStatement(requete3);
            st.setString(1, login);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
            u=new User();
            u.setId((rs.getInt(1)));
            id_user=u.getId();
            }
            
            
        }
        catch(SQLException ex){
            //System.out.println("erreur recherche");
            ex.printStackTrace();
        }
        return id_user;
        
    }
public List<User> DisplayAllUser() {
        List<User> listeparticipant = new ArrayList<>();

        String requete = "select * from participant";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                User p = new User();
                p.setId(resultat.getInt(1));
                p.setNom(resultat.getString(2));

                listeparticipant.add(p);
            }
            return listeparticipant;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
 public int calculNombreClient(){
        
        String requete = "SELECT count(*) FROM fos_user WHERE roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}'";
        int nombreClient = 0;
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                
                nombreClient=rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreClient;
    }
public int calculNombreAnnonceur(){
        
        String requete = "SELECT count(*) FROM fos_user WHERE roles='a:1:{i:0;s:14:\"ROLE_ANNONCEUR\";}'";
        int nombreAnnonceur = 0;
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                
                nombreAnnonceur=rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreAnnonceur;
    }
 public int retournerId(String u) {
        String requete = "SELECT id FROM fos_user where username=? ";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1, u);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //System.out.println("Erreur d'ajout");
        }
        return 0;
    }
}
