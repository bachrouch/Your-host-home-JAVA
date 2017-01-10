/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.dao.NoteDAO;
import com.esprit.dao.OffreDAO;
import com.esprit.entities.Note;
import com.esprit.entities.Offre;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Houssem
 */
public class Administrateur extends javax.swing.JFrame {

    /**
     * Creates new form Administrateur1
     */
    int id1 = 0;
    int id2 = 0;
    int id3 = 0;
    int id4 = 0;
    int id5 = 0;
    int id6 = 0;
    static int id_offre;
    OffreDAO off = new OffreDAO();

    public Administrateur() {
        initComponents();

        do {
            id1 = off.IdParHazard();
            id2 = off.IdParHazard(); //(id2==id1)||
            id3 = off.IdParHazard(); //(id2==id3)||(id1==id3)||
            id4 = off.IdParHazard(); //(id1==id4)||(id2==id4)||(id3==id4)||
            id5 = off.IdParHazard(); //(id1==id5)||(id2==id5)||(id3==id5)||(id4==id5)||
            id6 = off.IdParHazard(); //(id1==id5)||(id2==id5)||(id3==id5)||(id4==id5)||
        } while (id1 == id6 || id2 == id6 || id3 == id6 || id4 == id6 || id5 == id6 || id6 == 0 || id3 == 0 || id5 == 0 || id4 == 0 || id1 == 0 || id2 == 0 || (id2 == id1) || (id2 == id3) || (id1 == id3) || (id1 == id4) || (id2 == id4) || (id3 == id4) || (id1 == id5) || (id2 == id5) || (id3 == id5) || (id4 == id5));

//        do{
//            id5= off.IdParHazard();
//        }while((id5==id1)&&(id5==id2)&&(id5==id3)&&(id5==id4));
        jLabel1.setText(off.trouverTitreApprouverById(id1));
        System.out.println(id1);
        System.out.println(jLabel1.getText());
        jLabel2.setText(off.trouverTitreApprouverById(id2));
        System.out.println(id2);
        System.out.println(jLabel2.getText());
        jLabel3.setText(off.trouverTitreApprouverById(id3));
        System.out.println(id3);
        System.out.println(jLabel3.getText());
        jLabel4.setText(off.trouverTitreApprouverById(id4));
        System.out.println(id4);
        System.out.println(jLabel4.getText());
        jLabel5.setText(off.trouverTitreApprouverById(id5));
        System.out.println(id5);
        System.out.println(jLabel5.getText());
        jLabel6.setText(off.trouverTitreApprouverById(id6));
        System.out.println(id6);
        System.out.println(jLabel6.getText());
        /**
         * **************get image****************** //
         */
        if (off.trouverTitreApprouverById(id1) != null) {
            OffreDAO od2 = new OffreDAO();
            Offre o2 = new Offre();
            o2 = od2.rechercherOffreById(id1);
            byte[] img1 = o2.getPhoto1();
            ImageIcon icon1 = new ImageIcon(img1);
            Image img = icon1.getImage();
            BufferedImage bi = new BufferedImage(jLabel11.getWidth(), jLabel11.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, jLabel11.getWidth(), jLabel11.getHeight(), null);
            ImageIcon newIcon = new ImageIcon(bi);
            jLabel11.setIcon(newIcon);
        }

        if (off.trouverTitreApprouverById(id2) != null) {
            OffreDAO od3 = new OffreDAO();
            Offre o3 = new Offre();
            o3 = od3.rechercherOffreById(id2);
            byte[] img2 = o3.getPhoto1();
            ImageIcon icon2 = new ImageIcon(img2);
            Image img13 = icon2.getImage();
            BufferedImage bi1 = new BufferedImage(jLabel12.getWidth(), jLabel12.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g1 = bi1.createGraphics();
            g1.drawImage(img13, 0, 0, jLabel12.getWidth(), jLabel12.getHeight(), null);
            ImageIcon newIcon1 = new ImageIcon(bi1);
            jLabel12.setIcon(newIcon1);
        }

        if (off.trouverTitreApprouverById(id3) != null) {
            OffreDAO od4 = new OffreDAO();
            Offre o4 = new Offre();
            o4 = od4.rechercherOffreById(id3);
            byte[] img3 = o4.getPhoto1();
            ImageIcon icon3 = new ImageIcon(img3);
            Image img14 = icon3.getImage();
            BufferedImage bi2 = new BufferedImage(jLabel13.getWidth(), jLabel13.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g2 = bi2.createGraphics();
            g2.drawImage(img14, 0, 0, jLabel13.getWidth(), jLabel13.getHeight(), null);
            ImageIcon newIcon2 = new ImageIcon(bi2);
            jLabel13.setIcon(newIcon2);
        }

        if (off.trouverTitreApprouverById(id4) != null) {
            OffreDAO od5 = new OffreDAO();
            Offre o5 = new Offre();
            o5 = od5.rechercherOffreById(id4);
            byte[] img4 = o5.getPhoto1();
            ImageIcon icon4 = new ImageIcon(img4);
            Image img15 = icon4.getImage();
            BufferedImage bi3 = new BufferedImage(jLabel14.getWidth(), jLabel14.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g3 = bi3.createGraphics();
            g3.drawImage(img15, 0, 0, jLabel14.getWidth(), jLabel14.getHeight(), null);
            ImageIcon newIcon3 = new ImageIcon(bi3);
            jLabel14.setIcon(newIcon3);
        }

        if (off.trouverTitreApprouverById(id5) != null) {
            OffreDAO od6 = new OffreDAO();
            Offre o6 = new Offre();
            o6 = od6.rechercherOffreById(id5);
            byte[] img5 = o6.getPhoto1();
            ImageIcon icon5 = new ImageIcon(img5);
            Image img16 = icon5.getImage();
            BufferedImage bi4 = new BufferedImage(jLabel15.getWidth(), jLabel15.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g4 = bi4.createGraphics();
            g4.drawImage(img16, 0, 0, jLabel15.getWidth(), jLabel15.getHeight(), null);
            ImageIcon newIcon4 = new ImageIcon(bi4);
            jLabel15.setIcon(newIcon4);
        }

        if (off.trouverTitreApprouverById(id6) != null) {
            OffreDAO od7 = new OffreDAO();
            Offre o7 = new Offre();
            o7 = od7.rechercherOffreById(id6);
            byte[] img6 = o7.getPhoto1();
            ImageIcon icon6 = new ImageIcon(img6);
            Image img17 = icon6.getImage();
            BufferedImage bi5 = new BufferedImage(jLabel16.getWidth(), jLabel16.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g5 = bi5.createGraphics();
            g5.drawImage(img17, 0, 0, jLabel16.getWidth(), jLabel16.getHeight(), null);
            ImageIcon newIcon5 = new ImageIcon(bi5);
            jLabel16.setIcon(newIcon5);
        }

        /**
         * *************************************************
         */
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
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 140, 110, 130);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 140, 110, 130);

        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 130, 240, 150);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(390, 140, 110, 130);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(280, 140, 110, 130);

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 130, 240, 150);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(650, 140, 110, 130);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(540, 140, 110, 130);

        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(530, 130, 240, 150);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 310, 110, 130);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 310, 110, 130);

        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 300, 240, 150);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(390, 310, 110, 130);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(280, 310, 110, 130);

        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(270, 300, 240, 150);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(650, 310, 110, 130);
        getContentPane().add(jLabel16);
        jLabel16.setBounds(540, 310, 110, 130);

        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(530, 300, 240, 150);

        jButton7.setText("Gestion des Commentaires");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(180, 30, 180, 40);

        jButton8.setText("Statistiques");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(40, 30, 100, 40);

        jButton9.setText("Déconnexion");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton9MouseReleased(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(673, 10, 100, 23);

        jLabel7.setFont(new java.awt.Font("Cambria", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Liste des nouvelles offres en attente:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(220, 90, 340, 30);

        setSize(new java.awt.Dimension(797, 524));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Statistique stat = new Statistique();
        stat.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        if (off.trouverTitreApprouverById(id1) != null) {
            id_offre = id1;
            OffrePourApprouver offre1 = new OffrePourApprouver();
            offre1.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        if (off.trouverTitreApprouverById(id2) != null) {
            id_offre = id2;
            OffrePourApprouver offre2 = new OffrePourApprouver();
            offre2.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        if (off.trouverTitreApprouverById(id3) != null) {
            id_offre = id3;
            OffrePourApprouver offre3 = new OffrePourApprouver();
            offre3.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        if (off.trouverTitreApprouverById(id4) != null) {
            id_offre = id4;
            OffrePourApprouver offre4 = new OffrePourApprouver();
            offre4.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        if (off.trouverTitreApprouverById(id5) != null) {
            id_offre = id5;
            OffrePourApprouver offre5 = new OffrePourApprouver();
            offre5.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        if (off.trouverTitreApprouverById(id6) != null) {
            id_offre = id6;
            OffrePourApprouver offre6 = new OffrePourApprouver();
            offre6.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseReleased
        Login log = new Login();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton9MouseReleased

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased

        NoteDAO no = new NoteDAO();
        Note n = new Note();
        n = no.findNoteEnAttente();
        System.out.println("***********");
        System.out.println(n.getId());
        if (n.getId() == 0) {
            JFrame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Il n'y a pas de commentaires");

        } else {
            ApprouverCommentaire ap = new ApprouverCommentaire();
            ap.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Administrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
