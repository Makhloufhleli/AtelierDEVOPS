/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.iservicedao;

import model.entities.Etudiant;

/**
 *
 * @author Makhlouf Helali
 */
public interface IDAOGererEtudiant {
    public boolean ajouterEtudiant(Etudiant etudiant);
    public boolean modifierEtudiant(Etudiant etudiant);
    public boolean suprimerEtudiant(Etudiant etudiant);
    public boolean getEtudiantById(int id);
}
