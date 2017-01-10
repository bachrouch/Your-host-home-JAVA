/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.esprit.entities.Offre;
import com.esprit.entities.User;
import com.esprit.util.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.table.AbstractTableModel;
import static com.esprit.gui.Afficher_annonce.tableOrg;

/**
 *
 * @author maher
 */
public class OffreDAO {

    Connection cnx;

    public OffreDAO() {
        cnx = MyConnection.getInstance();
    }

    Statement statement = null;

    public void ajouterOffre(Offre off, int id1) {
        Connection cnx1 = MyConnection.getInstance();
        String requete = "INSERT INTO `offre`( `titre`, `type`, `nbrepiece`, `datedebut`, `datefin`, `superficie`, `prix`, `description`, `gouvernorat`, `delegation`, `localite`, `codepostal`,`photo1`,`photo2`,`photo3`,`publication`,`notemoy`,`iduser`)  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            UserDAO a = new UserDAO();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            PreparedStatement st = cnx1.prepareStatement(requete);
            st.setString(1, off.getTitre());
            st.setInt(2, off.getType());
            st.setInt(3, off.getNbrepiece());
            st.setDate(4, off.getDateDebut());
            st.setDate(5, off.getDateFin());
           
            st.setFloat(6, off.getSuperFicie());
            st.setFloat(7, off.getPrix());
            st.setString(8, off.getDescription());
            st.setString(9, off.getGouvernorat());
            st.setString(10, off.getDelegation());
            st.setString(11, off.getLocalite());
            st.setInt(12, off.getCodePostal());
            st.setBytes(13, off.getPhoto1());
            st.setBytes(14, off.getPhoto2());
            st.setBytes(15, off.getPhoto3());
            st.setInt(16, 0);
            st.setInt(17, 0);
            st.setInt(18, id1);
//            st.setBoolean(14, false);
//            st.setFloat(15, off.getNoteMoy());
//            st.setInt(16, a.retournerId("maher"));
            st.executeUpdate();
            System.out.println("objet ajouté");
        } catch (SQLException ex) {

            System.out.println("Echec d'insertion !!! " + ex.getMessage());
            ex.printStackTrace();
        }
    }

   public boolean modifierOffre(Offre off, int iduser) {

        boolean testUpdate = false;
        String req = "UPDATE `offre` SET `titre`=?,`type`=?,`nbrepiece`=?,`datedebut`=?,`datefin`=?,`superficie`=?,`prix`=?,`description`=?,`gouvernorat`=?,`delegation`=?,`localite`=?,`codepostal`=? WHERE ID =" + iduser;

        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, off.getTitre());
            st.setInt(2, off.getType());
            st.setInt(3, off.getNbrepiece());
            st.setDate(4, off.getDateDebut());
            st.setDate(5, off.getDateFin());
            st.setFloat(6, off.getSuperFicie());
            st.setFloat(7, off.getPrix());
            st.setString(8, off.getDescription());
            st.setString(9, off.getGouvernorat());
            st.setString(10, off.getDelegation());
            st.setString(11, off.getLocalite());
            st.setInt(12, off.getCodePostal());
            //st.setBoolean(13, false);

            int res = st.executeUpdate();

            if (res != 0) {
                testUpdate = true;
                System.out.println("Mise a  jour effectuée avec succés :) ");
            }

        } catch (SQLException ex) {

            System.out.println("Echec de la mise Ã  jour !!!  " + ex.getMessage());
            ex.printStackTrace();
        }
        return testUpdate;
    }
    public boolean modifierOffre2(Offre off, int iduser)
    {
    
    
        boolean testUpdate = false;
        String req = "UPDATE offre SET titre=?,type=?,nbrepiece=?,datedebut=?,datefin=?,superficie=?,prix=?,description=?,gouvernorat=?,delegation=?,localite=?,codepostal=?,publication=? WHERE ID =" + iduser;

        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, off.getTitre());
            st.setInt(2, off.getType());
            st.setInt(3, off.getNbrepiece());
            st.setDate(4, off.getDateDebut());
            st.setDate(5, off.getDateFin());
            st.setFloat(6, off.getSuperFicie());
            st.setFloat(7, off.getPrix());
            st.setString(8, off.getDescription());
            st.setString(9, off.getGouvernorat());
            st.setString(10, off.getDelegation());
            st.setString(11, off.getLocalite());
            st.setInt(12, off.getCodePostal());
//            st.setByte(13, off.getPhoto1());
//            st.setByte(14, off.getPhoto2());
//            st.setByte(15, off.getPhoto3());
            st.setInt(13,off.getPublication());
            
            int res = st.executeUpdate();

            if (res != 0) {
                testUpdate = true;
                System.out.println("Mise a  jour effectuée avec succ¨s émoticône smile ");
            }

        } catch (SQLException ex) {

            System.out.println("Echec de la mise Ã  jour !!!  " + ex.getMessage());
            ex.printStackTrace();
        }
        return testUpdate;
    }
    
    
     public boolean deleteOffre(int id) {
        boolean testDelete = false;
        String requ = "delete from offre where id=?";

        try {
            PreparedStatement st = cnx.prepareStatement(requ);
            st.setInt(1, id);
            int res = st.executeUpdate();
            if (res != 0) {
                testDelete = true;
                System.out.println("Une offre a Ã©tÃ© suuprimÃ©e avec succÃ©e :) ");
            }

        } catch (SQLException ex) {

            System.out.println("Echec de suppression ! " + ex.getMessage());
            ex.printStackTrace();
        }
        return testDelete;
    }
    // ***************************************************************

    public Offre rechercherOffreById(int id) {
        String requete = "SELECT * FROM offre where id=?";

        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1, id);
            ResultSet res = st.executeQuery();
            Offre off = new Offre();
            while (res.next()) {

                off.setId(res.getInt(1));
                off.setTitre(res.getString(2));
                off.setType(res.getInt(3));
                off.setNbrepiece(res.getInt(4));
                off.setDateDebut(res.getDate(5));
                off.setDateFin(res.getDate(6));
              //  off.setDatePublication(res.getDate(17));
                off.setSuperFicie(res.getFloat(7));
                off.setPrix(res.getFloat(8));
                off.setDescription(res.getString(9));
                off.setGouvernorat(res.getString(10));
                off.setDelegation(res.getString(11));
                off.setLocalite(res.getString(12));
                 off.setCodePostal(res.getInt(13));
                off.setPhoto1(res.getBytes(14));
               off.setPhoto2(res.getBytes(15));
               off.setPhoto3(res.getBytes(16));
//                off.setPublication(res.getBoolean(15));
//                off.setNoteMoy(res.getFloat(16));
            }
            return off;
        } catch (SQLException ex) {
            System.out.println("Echec de retrouver cette offre" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    public Offre rechercherOffreByType(String type) {
        String requete = "select * from offre where type=?";

        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(2, type);
            ResultSet res = st.executeQuery();
            Offre off = new Offre();
            while (res.next()) {
                off.setId(res.getInt(1));
                off.setTitre(res.getString(2));
                off.setType(res.getInt(3));
                off.setNbrepiece(res.getInt(4));
                off.setDateDebut(res.getDate(5));
                off.setDateFin(res.getDate(6));
                off.setDatePublication(res.getDate(7));
                off.setSuperFicie(res.getFloat(8));
                off.setPrix(res.getFloat(9));
                off.setDescription(res.getString(10));
                off.setGouvernorat(res.getString(11));
                off.setDelegation(res.getString(12));
                off.setLocalite(res.getString(13));
                off.setCodePostal(res.getInt(14));
                off.setPublication(res.getInt(15));
                off.setNoteMoy(res.getFloat(16));

                return off;
            }
        } catch (SQLException ex) {
            System.out.println("Echec de retrouver cette offre" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        return null;
    }
     public ArrayList<String> rechercherOffreByType(int type) {

      String requete = "SELECT * FROM `offre` WHERE type=?";
        Offre off;
        ArrayList<String> id = new ArrayList<String>();
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, type);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                off = new Offre();
                off.setId(rs.getInt(1));
                String offId= rs.getInt(1)+"";
                id.add(offId) ;
                

            }
        } catch (SQLException ex) {

            System.out.println("Echec de retrouver cette offre" + ex.getMessage());
            ex.printStackTrace();
        }

        return id;
    }
      
            //*****************************************************************************

     
     
       public String trouverTitreById(int id) {

        Offre o = null;
        String requete = "SELECT `titre` FROM `offre` WHERE id=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                o = new Offre();
                o.setTitre(rs.getString(1));
                return (rs.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return null;

    }
        public int trouverIdbyTitre(String titre) {
        int a = 0;
       
        String requete = "SELECT * FROM offre WHERE titre=?";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1, titre);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                
                
                a=rs.getInt(1);
                return (a);
            }

        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return a;

    }
     
     
     
     
    /*
     
     public Offre rechercherOffreByDate(Date datePublication) {
     String requete = "select * from offre where datePublication=?";

     try {
     PreparedStatement st = cnx.prepareStatement(requete);
     st.setDate(5, (Date) datePublication);
     ResultSet res = st.executeQuery();
     Offre off = new Offre();
     while (res.next()) {
     off.setId(res.getInt(1));
     off.setTitre(res.getString(2));
     off.setType(res.getString(3));
     off.setNbrepiece(res.getInt(4));
     off.setDateDebut(res.getDate(5));
     off.setDateFin(res.getDate(6));
     off.setDatePublication(res.getDate(7));
     off.setSuperFicie(res.getFloat(8));
     off.setPrix(res.getFloat(9));
     off.setDescription(res.getString(10));
     off.setGouvernorat(res.getString(11));
     off.setDelegation(res.getString(12));
     off.setLocalite(res.getString(13));
     off.setCodePostal(res.getInt(14));
     off.setPublication(res.getBoolean(15));
     off.setNoteMoy(res.getFloat(16));
     }
     return off;
     } catch (SQLException ex) {
     System.out.println("Echec de retrouver cette offre !" + ex.getMessage());
     ex.printStackTrace();
     return null;
     }
     }
     */
    /*******************************************************/
       
       
       
        public ArrayList<String> rechercherOffreByGouvernorat(String gouv) {
          
        String requete = "SELECT * FROM `offre` WHERE gouvernorat=?";
        Offre off;
        ArrayList<String> id = new ArrayList<String>();
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, gouv);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                off = new Offre();
                off.setId(rs.getInt(1));
                String offId= rs.getInt(1)+"";
                id.add(offId) ;
                

            }
        } catch (SQLException ex) {

            System.out.println("Echec de retrouver cette offre" + ex.getMessage());
            ex.printStackTrace();
        }

        return id;

    }
      
     
      /****************************************************************************/
      /*public Byte[] affichagePhotoById( int id){
          Offre o = null;
          String requete = "SELECT photo1 FROM `offre` WHERE id=?";
           try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                o = new Offre();
                o.setTitre(rs.getString(1));
                return (rs.getBytes(1));
            }

        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return null;

    }*/
          
      
      
    /*****************************************************************************************/
      public ArrayList<String> rechercherOffreByLocalite(String loc) {
        String requete = "SELECT * FROM `offre` WHERE localite=?";
        Offre off;
        ArrayList<String> id = new ArrayList<String>();
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, loc);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                off = new Offre();
                off.setId(rs.getInt(1));
                String offId= rs.getInt(1)+"";
                id.add(offId) ;
                

            }
        } catch (SQLException ex) {

            System.out.println("Echec de retrouver cette offre" + ex.getMessage());
            ex.printStackTrace();
        }

        return id;

    }
/*********************************************************************/
      public  ArrayList<String> rechercherOffreByDate(java.sql.Date d1, java.sql.Date d2) {
        String requete = "select * from offre where dateDebut=? ";//and dateFin=?";
        Offre off;
         ArrayList<String> id = new ArrayList<String>();
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setDate(1, (java.sql.Date) d1);
            // st.setDate(2, (java.sql.Date) d2);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                off = new Offre();
                off.setId(res.getInt(1));
                String offId= res.getInt(1)+"";
                id.add(offId) ;
                

            }
        } catch (SQLException ex) {

            System.out.println("Echec de retrouver cette offre" + ex.getMessage());
            ex.printStackTrace();
        }

        return id;
    }
      /*********************************************************************************/
         public ArrayList<String> rechercherOffreByPrix(float prix1, float prix2) {
          
        String requete = "SELECT * FROM `offre` WHERE  `prix`  BETWEEN ? AND ?";
        Offre off;
        ArrayList<String> id = new ArrayList<String>();
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
         ps.setFloat(1, prix1);
           ps.setFloat(2, prix2);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                off = new Offre();
                off.setId(rs.getInt(1));
                String offId= rs.getInt(1)+"";
                id.add(offId) ;
                

            }
        } catch (SQLException ex) {

            System.out.println("Echec de retrouver cette offre" + ex.getMessage());
            ex.printStackTrace();
        }

        return id;

    }

       
       
       /*********************************************************/
    
      public void update_tableorg(int id_org) {

        //Connection conn = null;
        //PreparedStatement pst = null;
        //conn = MyConnection.connecrDb();
        try { //`titre`,`type`,`nbrepiece`,`datedebut`,`datefin`,`superficie`,`prix`,`description`,`gouvernorat`,`delegation`,`localite`,`codepostal`
           // String sql = "SELECT * FROM offre  WHERE Iduser = "+id_org;
            String sql ="SELECT `id`, `titre`, `nbrepiece`, `datedebut`, `datefin`, `superficie`, `prix`, `description`, `gouvernorat`, `delegation`, `localite` FROM `offre` WHERE IDUSER ="+id_org+" and publication=1";
            Statement stat = cnx.createStatement();
            
            //pst.setInt(1, id_org);
            ResultSet rs = stat.executeQuery(sql);

            tableOrg.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()){
            System.out.println(rs.getInt(1));
            }
            
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
       public String trouverTitreApprouverById(int id) {
        int x = 0;
        Offre o = null;
        String requete = "SELECT titre FROM offre WHERE id=" + id + " AND publication=" + x;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                o = new Offre();
                o.setTitre(rs.getString(1));
                return (rs.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return null;

    }
       public List<Offre> afficherOffreById(int id){
           List<Offre> mesOffres = new ArrayList<>();
          Offre off = new Offre();
       String requete = "SELECT  `titre`, `type`, `datedebut`, `datefin`, `prix`,  `gouvernorat`  FROM `offre` WHERE id=" + id;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                
               
                off.setTitre(rs.getString(1));
                off.setType(rs.getInt(2));
               
                off.setDateDebut(rs.getDate(3));
                off.setDateFin(rs.getDate(4));
                off.setPrix(rs.getFloat(5));
                
                off.setGouvernorat(rs.getString(6));
               
                 mesOffres.add(off);
                
            }

        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
       
       return mesOffres;
       }
//public String GetGouvernoratbyid(int id){
//
//
//
//}
    public int IdParHazard() {
        int valeur = (int) (Math.random() * 7);
        return valeur;
    }

    public String trouverTitreParHazard() {
        int x = 0;
        String titre = null;
        while (titre == null) {
            x = IdParHazard();
            titre = trouverTitreApprouverById(x);
        }
        return titre;
    }

    public int calculNombreOffreEnAttente() {
        String requete = "SELECT count(*) FROM offre WHERE publication=0";
        int nombreOffre = 0;
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                nombreOffre = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreOffre;
    }

    public int calculNombreOffreApprouver() {
        String requete = "SELECT count(*) FROM offre WHERE publication=1";
        int nombreOffre = 0;
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                nombreOffre = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreOffre;
    }

    public int calculNombreOffreDeapprouver() {
        String requete = "SELECT count(*) FROM offre WHERE publication=2";
        int nombreOffre = 0;
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                nombreOffre = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreOffre;
    }

    public void approuverOffre(int id) {
        String requete = "UPDATE `offre` SET `publication`=? WHERE id=" + id;
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

    public void deapprouverOffre(int id) {
        String requete = "UPDATE `offre` SET `publication`=? WHERE id=" + id;
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
     public List<Offre> retrouverTousLesOffres() {
        List<Offre> mesOffres = new ArrayList<>();
        String requete = "select * from offre";

        try {

            PreparedStatement rt = cnx.prepareStatement(requete);
            ResultSet res = rt.executeQuery();

            while (res.next()) {
                Offre off = new Offre();
                off.setId(res.getInt(1));
                off.setTitre(res.getString(2));
                off.setType(res.getInt(3));
                off.setNbrepiece(res.getInt(4));
                off.setDateDebut(res.getDate(5));
                off.setDateFin(res.getDate(6));
//                off.setDatePublication(res.getDate(7));
                off.setSuperFicie(res.getFloat(7));
                off.setPrix(res.getFloat(8));
                off.setDescription(res.getString(9));
                off.setGouvernorat(res.getString(10));
                off.setDelegation(res.getString(11));
                off.setLocalite(res.getString(12));
                off.setCodePostal(res.getInt(13));
                off.setPhoto1(res.getBytes(14));
                off.setPhoto2(res.getBytes(15));
                off.setPhoto3(res.getBytes(16));
                off.setPublication(res.getInt(17));
                off.setNoteMoy(res.getFloat(18));

                mesOffres.add(off);
            }
            return mesOffres;
        } catch (SQLException ex) {
            System.out.println("Echec d'afficher la liste des offres!!! " + ex.getMessage());
            return null;
        }
    }
}