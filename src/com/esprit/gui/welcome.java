/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import AppPackage.AnimationClass;


import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author pc
 */
public class welcome extends javax.swing.JFrame {
 AnimationClass AC =new AnimationClass();
    public welcome() {
        initComponents();
        Slideshow();
        this.setVisible(false);
    }
     
    
    public void Slideshow(){
        new Thread (){
            int count;
            public void run(){
                try{
                    
        
                               Thread.sleep(2000);
                                AC.jLabelXLeft(0, -610, 60,7, jLabel1);
                                AC.jLabelXLeft(610, 0, 60,7, jLabel2);
                                Thread.sleep(5000);
                     
                                
                                
                                conversation l = new conversation();
                                l.setVisible(true);
                                l.setSize(1075, 728);
                                l.setLocationRelativeTo(null);
                                
                                
                            
                        }
                        
                    
                    
   
                catch(Exception e){
                    
                }
            }
            
        }.start();
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
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/gui/1_1.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(610, 380));
        jLabel1.setMinimumSize(new java.awt.Dimension(610, 380));
        jLabel1.setPreferredSize(new java.awt.Dimension(610, 380));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 610, 380);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/gui/darkom logo.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(610, 380));
        jLabel2.setMinimumSize(new java.awt.Dimension(610, 380));
        jLabel2.setPreferredSize(new java.awt.Dimension(610, 380));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(610, 0, 610, 380);

        setSize(new java.awt.Dimension(623, 414));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new welcome().setVisible(true);
               
                 
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
