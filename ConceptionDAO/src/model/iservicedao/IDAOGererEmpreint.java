/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.iservicedao;

import java.util.List;
import model.entities.Empreint;
import model.entities.Etudiant;
import model.entities.Exemplaire;

/**
 *
 * @author Makhlouf Helali
 */
public interface IDAOGererEmpreint {
    public boolean ajouterEmpreint(Empreint empreint);
    public List<Empreint> getAllEmpreints();
    public Empreint getEmpreintById(int id);
    public Etudiant getEmpreintEtudiant(Empreint empreint);
    public Exemplaire getEmpreintExemplaire(Empreint empreint);
}
