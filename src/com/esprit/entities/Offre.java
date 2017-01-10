/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;

/**
 *
 * @author maher
 */
public class Offre {
    private int id;
    private String titre;
    private int type;
    private int nbrepiece;
    private Date dateDebut;
    private Date dateFin;
    private Date datePublication;
    private byte[] photo1;
    private byte[] photo2;
    private byte[] photo3;
    
    private float superFicie;
    private float prix;
    private String description;
    private String gouvernorat;
    private String delegation;
    private String localite;
    private int codePostal;
    private int publication;
    private float noteMoy;

    public Offre(){}
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNbrepiece() {
        return nbrepiece;
    }

    public void setNbrepiece(int nbrepiece) {
        this.nbrepiece = nbrepiece;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public float getSuperFicie() {
        return superFicie;
    }

    public void setSuperFicie(float superFicie) {
        this.superFicie = superFicie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public float getNoteMoy() {
        return noteMoy;
    }

    public void setNoteMoy(float noteMoy) {
        this.noteMoy = noteMoy;
    }
     public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public byte[] getPhoto1() {
        return photo1;
    }

    public byte[] getPhoto2() {
        return photo2;
    }

    public byte[] getPhoto3() {
        return photo3;
    }

    public void setPhoto1(byte[] photo1) {
        this.photo1 = photo1;
    }

    public void setPhoto2(byte[] photo2) {
        this.photo2 = photo2;
    }

    public void setPhoto3(byte[] photo3) {
        this.photo3 = photo3;
    }

   
    
}
