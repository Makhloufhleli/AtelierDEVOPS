/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.icontroller;

import java.util.List;
import javafx.scene.layout.BorderPane;
import model.business.BusinessGererLivre;
import model.entities.Livre;

/**
 *
 * @author Makhlouf Helali
 */
public interface ILivreCOntroller {
    public void afficherLivreView(BorderPane root);
    public void ajouterLivre(BorderPane root);
    public List<Livre> getAllLivres();
}
