/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business;

import java.util.List;
import model.entities.Exemplaire;
import model.entities.Livre;
import model.iservicedao.IDAOGererLivre;

/**
 *
 * @author Makhlouf Helali
 */
public class BusinessGererLivre {
    private Livre livre;
    private IDAOGererLivre daoGererLivre;

    public void setDaoGererLivre(IDAOGererLivre _daoGererLivre) {
        this.daoGererLivre = _daoGererLivre;
    }

    public boolean ajouterLivre(Livre L){
        return (daoGererLivre.ajouterLivre(L));
    }
    
    public List<Livre> getAllLivres(){
        return daoGererLivre.getAllLivres();
    }
    
    public Livre getLivreByIsbn(String isbn){
        return daoGererLivre.getLivreByIsbn(isbn);
    }
    
    public void supprimerLivre(Livre livre, List<Exemplaire> listExemplaires){
        daoGererLivre.supprimerLivre(livre, listExemplaires);
    }
    
    public void modifierLivre(Livre livre){
        daoGererLivre.modifierLivre(livre);
    }
    public boolean ajouterExemplaire(Exemplaire exemplaire){
        return daoGererLivre.ajouterExemplaire(exemplaire);
    }
    
    public List<Exemplaire> getLivreExemplaires(Livre livre){
        return daoGererLivre.getLivreExemplaires(livre);
    }
    
}
