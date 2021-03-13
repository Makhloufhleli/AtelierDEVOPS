/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.iview;

import javafx.scene.layout.BorderPane;
import view.viewimp.MainViewImp;

/**
 *
 * @author Makhlouf Helali
 */
public interface IMainView {
    public void afficherMainView(BorderPane root);
    public MainViewImp getMainView();
}
