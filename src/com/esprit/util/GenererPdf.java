package com.esprit.util;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.esprit.dao.UserDAO;
import com.esprit.entities.User;
import com.esprit.entities.Offre;
import com.esprit.dao.OffreDAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
//import tn.smarttransport.gestionreservation.entite.Reservation;
//import tn.smarttransport.gestionvoyageur.entite.Carte;
//import tn.smarttransport.gestionvoyageur.entite.Voyageur;

/**
 *
 * @author Maalej Ahmed
 */
public class GenererPdf {

    private String NomFichier;
    private List<Offre> offres;

    public GenererPdf(String NomFichier,  List<Offre> offres) {
        this.NomFichier = NomFichier;
        
        this.offres=offres;
    }
    

    public void GenererReservationOffre() {
        Document document = new Document();
        OffreDAO T = new OffreDAO();
        try {
            PdfWriter.getInstance(document,
            new FileOutputStream(NomFichier));
            document.open();

            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            Font fontbold = FontFactory.getFont("Times-Roman", 18, Font.BOLD);
            Chunk chunk0 = new Chunk(" Réservation \n\n\n");
            chunk0.setFont(fontbold);
            paragraph.add(chunk0);
            for (int i = 0; i < offres.size(); i++) {
                Chunk chunk1 = new Chunk("Titre: " + offres.get(i).getTitre()+ " \n ");
                Chunk chunk2 = new Chunk("Type: " + offres.get(i).getType()+ " \n ");
                Chunk chunk3 = new Chunk("Gouvernorat: " + offres.get(i).getGouvernorat()+ " \n ");
                Chunk chunk4 = new Chunk("Date début: " + offres.get(i).getDateDebut()+" \n ");
                Chunk chunk5 = new Chunk("Date Fin: " + offres.get(i).getDateFin().toString()+ "\n");
                 Chunk chunk6 = new Chunk("Prix: " + offres.get(i).getPrix() + "\n");
                Chunk chunk7 = new Chunk("------------------------------------------------------------\n");
  
                paragraph.add(chunk1);
                paragraph.add(chunk2);
                paragraph.add(chunk3);
                paragraph.add(chunk4);
                paragraph.add(chunk5);
                paragraph.add(chunk6);
                paragraph.add(chunk7);
            }
   
            document.add(paragraph);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    

    
   
}