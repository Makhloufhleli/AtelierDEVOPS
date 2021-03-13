/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.iservicedao;

import java.util.List;
import model.entities.Exemplaire;
import model.entities.Livre;

/**
 *
 * @author Makhlouf Helali
 */
public interface IDAOGererLivre {
    public boolean ajouterLivre(Livre livre);
    public List<Livre> getAllLivres();
    public Livre getLivreByIsbn(String isbn);
    public void supprimerLivre(Livre livre, List<Exemplaire> livreExemplaires);
    public void modifierLivre(Livre livre);
    public boolean ajouterExemplaire(Exemplaire exemplaire);
    public List<Exemplaire> getLivreExemplaires(Livre livre);
}
