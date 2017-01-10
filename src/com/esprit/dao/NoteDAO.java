/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.esprit.entities.Note;
import com.esprit.entities.Offre;
import com.esprit.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class NoteDAO {
     Connection cnx;
    public NoteDAO(){
    cnx=(Connection) MyConnection.getInstance();
    }
 Statement st= null; 
 
 
 
 
 /*****************************************************************/
   public void ajouterNote(Note n) {
    String requete = "INSERT INTO Note (`note` ,`commentaire`, `idoffre`,`statut` ) values (?,?,?,?)";
        try {
          PreparedStatement  st =cnx.prepareStatement(requete);
          st.setInt(1, n.getNote());
          st.setString(2, n.getCommentaire()); 
          st.setInt(3, n.getIdoffre());
          st.setInt(4, 0);
          
          st.executeUpdate();
          System.out.println("objet ajouté");
        } catch (SQLException ex) {
            
          System.out.println("objet non ajouté");   
        }   }  
  /******************************************************************/  
   public ArrayList<String> afficherCommentaire(int id){
        String requete = "SELECT * FROM `note` WHERE statut=1 AND idoffre="+id;
        Note nt;
        ArrayList<String> comm = new ArrayList<String>();
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            //ps.setInt(1, type);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                nt = new Note();
                nt.setCommentaire(rs.getString(3));
                String commentaire= rs.getString(3)+"";
                comm.add(commentaire) ;
                

            }
        } catch (SQLException ex) {

            System.out.println("Echec de retrouver cette offre" + ex.getMessage());
            ex.printStackTrace();
        }

        return comm;
   }
   
    
    public void supprimerNote(Note n){

        String requete = "delete from note where id=?";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1,n.getId());
            
            st.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression ");
        }
    }
    
    
     public void updateNote(Note n) {
        String requete = "update note  set commentaire=? where id=?";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
           
           st.setInt(1, n.getNote());
          
            st.setString(2, n.getCommentaire());
            
            st.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }

    }
     
     
     
     public Note findNoteById(int id) {
        String requete = "SELECT * FROM  Note where id=" + id ;
      Note u = null;
        try {
         st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            u = new Note();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setNote(rs.getInt(2)) ;   
                u.setCommentaire(rs.getString(3));
                u.setIduser(rs.getInt(4));
                u.setIdoffre(rs.getInt(5));
               
            }
        } catch (SQLException ex) {
            System.err.println("Erreur Recherche");
        }
        return u;
    }
     
     
     
  
    public java.util.List<Note> afficherNote() {
        java.util.List<Note> maListe = new ArrayList<>();
        String requete = "select * from note";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Note n = new Note();
                n.setId(rs.getInt(1));
                n.setCommentaire( rs.getString(2));
                n.setNote(rs.getInt(3));
                 n.setIdoffre(rs.getInt(4));
                  n.setIduser(rs.getInt(1));
               
                maListe.add(n);
            }
           
        } catch (SQLException ex) {
            System.err.println("Erreur d'affichege de la liste");;
        }

        return maListe;
    }
    public void approuverCommentaire(int id) {
        String requete = "UPDATE `note` SET `statut`=? WHERE id=" + id;
        int x = 1;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1, x);
            st.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }

    }

    public void masquerCommentaire(int id) {
        String requete = "UPDATE `note` SET `statut`=? WHERE id=" + id;
        int x = 2;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1, x);
            st.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }

    }
    
    public String trouverCommentaireByIdOffre(int id) {
        int x = 0;
        Note n = null;
        String requete = "SELECT commentaire FROM note WHERE idoffre=" + id + " AND statut=" + x;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                n = new Note();
                n.setCommentaire(rs.getString(1));
                return (rs.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return null;

    }
//     public String trouverCommentaireEnAttente() {
//        int x = 0;
//        Note n = null;
//        String requete = "SELECT commentaire FROM note WHERE statut=" + x;
//        try {
//            PreparedStatement st = cnx.prepareStatement(requete);
//            ResultSet rs = st.executeQuery(requete);
//
//            while (rs.next()) {
//                n = new Note();
//                n.setCommentaire(rs.getString(1));
//                return (rs.getString(1));
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("erreur recherche");
//        }
//        return null;
//
//    }
     
//  
    
    public Note findNoteEnAttente() {
        int x =0;
        String requete = "SELECT * FROM  Note where statut=" + x;
        Note n = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            n = new Note();
            while (rs.next()) {
                n.setId(rs.getInt(1));
                n.setNote(rs.getInt(2));
                n.setCommentaire(rs.getString(3));
                n.setIdoffre(rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.err.println("Erreur Recherche");
        }
        return n;
    }
    
    public float calcul_note(int id_offre, float note){
        String req = "SELECT count(*) from note WHERE idoffre=" + id_offre;
        String req1 = "SELECT notemoy from offre WHERE id=" + id_offre;
        float n =0;
		Offre o=new Offre();
        try {
            Statement st = cnx.createStatement();
            Statement st1 = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            ResultSet rs1 = st1.executeQuery(req1);
            while((rs.next())&&(rs1.next())){
            n = ((rs1.getInt(1)*rs.getInt(1)+note)/(rs.getInt(1)+1));
			}

        } catch (SQLException ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
        
        String requete = "UPDATE offre set notemoy=? WHERE id=" + id_offre;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setFloat(1, note);
            st.executeUpdate();
            System.out.println("Modification effectuée");
        } catch (SQLException ex) {
            System.err.println("Erreur de modification de la note moyenne de cette offre");
        }
        return n;
    }

    }
    

