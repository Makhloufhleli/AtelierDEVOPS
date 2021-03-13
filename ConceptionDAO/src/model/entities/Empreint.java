/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Makhlouf Helali
 */
public class Empreint {
    private int id;
    private Date dateEmpreint;
    private Date dateRetour;
    private List<Exemplaire> exemplaires;
    private List<Etudiant> etudiants;

    @Override
    public String toString() {
        return dateEmpreint + " -> " + dateRetour;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEmpreint() {
        return dateEmpreint;
    }

    public void setDateEmpreint(Date dateEmpreint) {
        this.dateEmpreint = dateEmpreint;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
    
    
}
