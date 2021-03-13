/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.iview;

import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import model.entities.Livre;
import view.viewimp.LivreViewImp;

/**
 *
 * @author Makhlouf Helali
 */
public interface ILivreView {
    public void afficherViewListLivres(BorderPane root, ArrayList<Livre> listLivres);
    public void afficherViewAddLivre(BorderPane root);
    public LivreViewImp getLivreView();
    public void afficherViewAddExemplaire(BorderPane root);
}
