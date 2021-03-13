/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.controllerimp;

import controller.icontroller.IEmpreintController;
import controller.icontroller.ILivreCOntroller;
import controller.icontroller.IMainController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import view.iview.IMainView;
import view.viewimp.MainViewImp;

/**
 *
 * @author Makhlouf Helali
 */
public class MainControllerImp implements IMainController{

    private IMainView imainView;
    
    @Override
    public void afficherMainView(BorderPane root) {
        String className = MainViewImp.class.getName();
        
         
        try {
            
            Class  mainViewClass = Class.forName(className);
            imainView =  (IMainView) mainViewClass.newInstance();
            imainView.afficherMainView(root);
            
            //Controle de menu livre
            Button menuLivres = imainView.getMainView().getMenuLivres();
            menuLivres.setOnAction(click->{
                try {
                    
                    String livresControllerclassName = LivreControllerImp.class.getName();
                    Class livreControllerClass = Class.forName(livresControllerclassName);
                    ILivreCOntroller livreController = (ILivreCOntroller) livreControllerClass.newInstance();
                    livreController.afficherLivreView(root);
                    
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(MainControllerImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            //Controle de menu empreint
            Button menuEmpreints = imainView.getMainView().getMenuEmpreints();
            menuEmpreints.setOnAction(click->{
                try {
                    
                    String empreintControllerclassName = EmpreintControllerImp.class.getName();
                    Class empreintControllerClass = Class.forName(empreintControllerclassName);
                    IEmpreintController empreintController = (IEmpreintController) empreintControllerClass.newInstance();
                    empreintController.afficherEmpreintView(root);
                    
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(MainControllerImp.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            });
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MainControllerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
