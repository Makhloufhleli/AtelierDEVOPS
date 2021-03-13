/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.iview;

import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import model.entities.Empreint;
import view.viewimp.EmpreintViewImp;

/**
 *
 * @author Makhlouf Helali
 */
public interface IEmpreintView {
    public void afficherViewListEmpreints(BorderPane root, ArrayList<Empreint> listEmpreints);
    public void afficherViewAddEmpreint(BorderPane root);
    public EmpreintViewImp getEmpreintView();
}
