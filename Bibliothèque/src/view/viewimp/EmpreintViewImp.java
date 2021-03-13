/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewimp;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.BorderPane;
import model.entities.Empreint;
import model.entities.Etudiant;
import view.iview.IEmpreintView;

/**
 *
 * @author Makhlouf Helali
 */
public class EmpreintViewImp implements IEmpreintView{

    @Override
    public void afficherViewListEmpreints(BorderPane root, ArrayList<Empreint> listEmpreints) {
        
        listEmpreints.forEach(empreint->{
            System.out.println(empreint.getId());
            List<Etudiant> empreintEtudiants = empreint.getEtudiants();
            empreintEtudiants.forEach(etudiant->{
                System.out.println(etudiant.toString());
            });
        });
    }

    @Override
    public void afficherViewAddEmpreint(BorderPane root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmpreintViewImp getEmpreintView() {
        return this;
    }
    
}
