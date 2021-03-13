/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author Makhlouf Helali
 */
public class Exemplaire extends Livre{
    private String codeExemplaire;
    private boolean empreinte;
    
    
    public String getCodeExemplaire() {
        return codeExemplaire;
    }

    public void setCodeExemplaire(String codeExemplaire) {
        this.codeExemplaire = codeExemplaire;
    }

    public boolean isEmpreinte() {
        return empreinte;
    }

    public void setEmpreinte(boolean empreinte) {
        this.empreinte = empreinte;
    }
    
    
    
    
}
