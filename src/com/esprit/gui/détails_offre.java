/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.dao.OffreDAO;
import com.esprit.dao.UserDAO;
import com.esprit.entities.Offre;
import com.esprit.entities.User;
import static com.esprit.gui.menuClient.id_loc;
import com.esprit.util.GenererPdf;
import com.esprit.util.GoogleMap;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.Document;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author wezza
 */
public class détails_offre extends javax.swing.JFrame {

    String ch1;
    //int static id_loc;
   

    /**
     * Creates new form détails_offre
     */
    public détails_offre() {
        initComponents();
        OffreDAO o = new OffreDAO();
        Offre o1 =null;
        o1 = o.rechercherOffreById(id_loc);
        Titre.setText(o1.getTitre());
        nbre_pieces.setText("" + o1.getNbrepiece());
        surface.setText(o1.getSuperFicie() + "");
        prix.setText(o1.getPrix() + "");
        jTextField1.setText(o1.getDescription());
        jTextField1.setEditable(false);
        Gouvernorat.setText(o1.getGouvernorat());
        ch1 = o1.getGouvernorat();
        délégation.setText(o1.getDelegation());
        code_postal.setText(o1.getCodePostal() + "");

 byte[] img1 = o1.getPhoto1();
        ImageIcon icon1 = new ImageIcon(img1);
        Image img = icon1.getImage();
        BufferedImage bi = new BufferedImage(photo1.getWidth(), photo1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, photo1.getWidth(), photo1.getHeight(), null);
        ImageIcon newIcon = new ImageIcon(bi);
        photo1.setIcon(newIcon);
       /****************************************/
//        byte[] img2 = o1.getPhoto2();
//        ImageIcon icon2 = new ImageIcon(img2);
//        Image img12 = icon2.getImage();
//        BufferedImage bi1 = new BufferedImage(photo2.getWidth(), photo2.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        Graphics g1 = bi1.createGraphics();
//        g1.drawImage(img12, 0, 0, photo2.getWidth(), photo2.getHeight(), null);
//        ImageIcon newIcon1 = new ImageIcon(bi1);
//        photo2.setIcon(newIcon1);
//        /***************************************/
//         byte[] img3 = o1.getPhoto3();
//        ImageIcon icon3 = new ImageIcon(img3);
//        Image img13 = icon3.getImage();
//        BufferedImage bi2 = new BufferedImage(photo3.getWidth(), photo3.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        Graphics g2 = bi2.createGraphics();
//        g2.drawImage(img13, 0, 0, photo3.getWidth(), photo3.getHeight(), null);
//        ImageIcon newIcon2 = new ImageIcon(bi2);
//        photo3.setIcon(newIcon2);
        /**************************************************/
        date_debut.setText(o1.getDateDebut().toString());
        date_fin.setText(o1.getDateFin().toString());
        if (o1.getType() == 0) {
            Type.setText("Chambre");
        } else {
            Type.setText("Maison d'hote");
        }

        //System.out.println(o1.getType());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Titre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date_fin = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        réserver = new javax.swing.JButton();
        Type = new javax.swing.JLabel();
        nbre_pieces = new javax.swing.JLabel();
        surface = new javax.swing.JLabel();
        délégation = new javax.swing.JLabel();
        Gouvernorat = new javax.swing.JLabel();
        prix = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        date_debut = new javax.swing.JLabel();
        code_postal = new javax.swing.JLabel();
        Map = new javax.swing.JToggleButton();
        Note = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        photo3 = new javax.swing.JLabel();
        photo2 = new javax.swing.JLabel();
        photo1 = new javax.swing.JLabel();
        Commentaire = new javax.swing.JButton();
        Note_moy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Titre.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Titre.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(Titre);
        Titre.setBounds(560, 110, 300, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Type :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 170, 150, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Localité :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(360, 500, 110, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Superficie :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 270, 150, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Prix :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 320, 150, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Nombre de pièces :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 220, 150, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Description :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 370, 150, 30);

        date_fin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        date_fin.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(date_fin);
        date_fin.setBounds(580, 580, 130, 30);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Date fin réservation :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(420, 580, 160, 30);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Délégation :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(610, 500, 100, 30);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Gouvernorat :");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 500, 130, 30);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Date début réservation :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(50, 580, 180, 30);

        back.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(880, 620, 140, 40);

        réserver.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        réserver.setText("Réserver");
        réserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                réserverActionPerformed(evt);
            }
        });
        getContentPane().add(réserver);
        réserver.setBounds(1070, 620, 140, 40);

        Type.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Type.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Type);
        Type.setBounds(260, 170, 300, 30);

        nbre_pieces.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        nbre_pieces.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nbre_pieces);
        nbre_pieces.setBounds(260, 220, 150, 30);

        surface.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        surface.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(surface);
        surface.setBounds(260, 270, 150, 30);

        délégation.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        délégation.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(délégation);
        délégation.setBounds(720, 500, 140, 30);

        Gouvernorat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Gouvernorat.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Gouvernorat);
        Gouvernorat.setBounds(190, 500, 140, 30);

        prix.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        prix.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(prix);
        prix.setBounds(260, 320, 150, 30);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Code postal :");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(860, 500, 110, 30);

        date_debut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        date_debut.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(date_debut);
        date_debut.setBounds(240, 580, 130, 30);

        code_postal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        code_postal.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(code_postal);
        code_postal.setBounds(980, 500, 100, 30);

        Map.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Map.setText("Map");
        Map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapActionPerformed(evt);
            }
        });
        getContentPane().add(Map);
        Map.setBounds(490, 500, 90, 30);

        Note.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        Note.setText("Noter & Commenter");
        Note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoteActionPerformed(evt);
            }
        });
        getContentPane().add(Note);
        Note.setBounds(360, 660, 240, 40);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTextField1.setCaretColor(new java.awt.Color(51, 51, 51));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField1.setSelectedTextColor(new java.awt.Color(37, 50, 100));
        jTextField1.setSelectionColor(new java.awt.Color(153, 153, 153));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 370, 880, 100);
        getContentPane().add(photo3);
        photo3.setBounds(1080, 390, 190, 180);
        getContentPane().add(photo2);
        photo2.setBounds(1080, 210, 190, 160);
        getContentPane().add(photo1);
        photo1.setBounds(1080, 10, 190, 180);

        Commentaire.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        Commentaire.setText("Afficher commentaires");
        Commentaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommentaireActionPerformed(evt);
            }
        });
        getContentPane().add(Commentaire);
        Commentaire.setBounds(50, 660, 240, 40);

        Note_moy.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        Note_moy.setText("Note moyenne");
        Note_moy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Note_moyActionPerformed(evt);
            }
        });
        getContentPane().add(Note_moy);
        Note_moy.setBounds(670, 660, 160, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/gui/arriere plan.jpg"))); // NOI18N
        jLabel3.setText("Titre");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -50, 1310, 950);

        setSize(new java.awt.Dimension(1295, 923));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapActionPerformed

        OffreDAO o = new OffreDAO();
        Offre o1 = new Offre();
        o1 = o.rechercherOffreById(menuClient.id_loc);
        Localiser c = new Localiser(o1.getGouvernorat());
        c.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_MapActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        menuClient acceuil = new menuClient();
        acceuil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void réserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_réserverActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Etes vous sur de réserver cette maison ou chambre !!!", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (confirm == JOptionPane.OK_OPTION) {
            OffreDAO o = new OffreDAO();
            Offre o1 = new Offre();
           
        List<Offre> offres = new Vector<>();
        offres = o.afficherOffreById(id_loc);
        GenererPdf pg = new GenererPdf("listee.pdf", offres);
        pg.GenererReservationOffre();
                 
                o1 = o.rechercherOffreById(id_loc);
//                Map param = new HashMap();
//                param.put("titre",o1.getTitre());
//                param.put("type",o1.getType() );
//                param.put("prix",o1.getPrix() );
//                param.put("datedebut",o1.getDateDebut());
//                param.put("datefin",o1.getDateFin());
//                System.out.println("hello");
//                JOptionPane.showMessageDialog(rootPane, "Vous avez réservé cette offre");
//                try {
//                    
//                    InputStream reportStream = this.getClass().getResourceAsStream("/com.esprit.gui/wezza.jrxml");
//                    
//                    JasperDesign jd = JRXmlLoader.load(reportStream);
//                    System.out.println("dfdfffff");
//                    String sql = "SELECT * FROM offre where id=" + o1.getId();
//                    JRDesignQuery query = new JRDesignQuery();
//                    query.setText(sql);
//                    jd.setQuery(query);
//                    JasperReport jr = JasperCompileManager.compileReport(jd);
////                    JasperPrint jp = JasperFillManager.fillReport(jr, param);
//                    JasperViewer.viewReport(jp, false);
//                    
//                    JasperExportManager.exportReportToPdfFile(jp, "D:\\wezza.pdf");
//                    
//
//                } catch (Exception ex) {
//                    System.out.println(ex);
//                }

                o1.setPublication(3);// 1 veut dire une offre réservée & 0 veux dire offre non réservée
                o.modifierOffre2(o1, id_loc);
                
                
                menuClient acceuil = new menuClient();
                acceuil.setVisible(true);
                this.setVisible(false);
            }else {
                    détails_offre détails=new détails_offre();
                    détails.setVisible(true);
                    this.setVisible(false);
                }


    }//GEN-LAST:event_réserverActionPerformed

    private void NoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoteActionPerformed

        // TODO add your handling code here:
        Note_Commentaire n = new Note_Commentaire();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_NoteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void CommentaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommentaireActionPerformed
        // TODO add your handling code here:
        AfficherTousLesCommentaires com = new AfficherTousLesCommentaires();
        com.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CommentaireActionPerformed

    private void Note_moyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Note_moyActionPerformed
        // TODO add your handling code here:
        Note_moyenne note = new Note_moyenne();
        note.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Note_moyActionPerformed

    /* @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(détails_offre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(détails_offre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(détails_offre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(détails_offre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new détails_offre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Commentaire;
    private javax.swing.JLabel Gouvernorat;
    private javax.swing.JToggleButton Map;
    private javax.swing.JButton Note;
    private javax.swing.JButton Note_moy;
    private javax.swing.JLabel Titre;
    private javax.swing.JLabel Type;
    private javax.swing.JButton back;
    private javax.swing.JLabel code_postal;
    private javax.swing.JLabel date_debut;
    private javax.swing.JLabel date_fin;
    private javax.swing.JLabel délégation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel nbre_pieces;
    private javax.swing.JLabel photo1;
    private javax.swing.JLabel photo2;
    private javax.swing.JLabel photo3;
    private javax.swing.JLabel prix;
    private javax.swing.JButton réserver;
    private javax.swing.JLabel surface;
    // End of variables declaration//GEN-END:variables
}
