/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.controllerimp;

import controller.icontroller.IEmpreintController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.BorderPane;
import model.business.BUsinessGererEmpreint;
import model.business.BusinessGererLivre;
import model.entities.Empreint;
import model.entities.Livre;
import model.iservicedao.IDAOGererEmpreint;
import model.iservicedao.IDAOGererLivre;
import model.serviceimpdao.DAOImpGererEmpreint;
import model.serviceimpdao.DAOImpGererLivre;
import view.iview.IEmpreintView;
import view.iview.ILivreView;
import view.viewimp.EmpreintViewImp;
import view.viewimp.LivreViewImp;

/**
 *
 * @author Makhlouf Helali
 */
public class EmpreintControllerImp implements IEmpreintController{

    private IEmpreintView empreintView;
    private BUsinessGererEmpreint serviceEmpreint;
    
    @Override
    public void afficherEmpreintView(BorderPane root) {
        String className = EmpreintViewImp.class.getName();
        try {
            
            Class livreViewClass = Class.forName(className);
            empreintView = (IEmpreintView) livreViewClass.newInstance();
            
            ArrayList<Empreint> listEmpreints = (ArrayList<Empreint>) getAllEmpreints();
            empreintView.afficherViewListEmpreints(root, listEmpreints);
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MainControllerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterEmpreint(BUsinessGererEmpreint businessEmpreint) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empreint> getAllEmpreints() {
        ArrayList<Empreint> listEmpreints = new ArrayList();
        String className = BUsinessGererEmpreint.class.getName();
        String daoGererEmpreintClassName = DAOImpGererEmpreint.class.getName();
        try {
            Class daoEmpreintsClass = Class.forName(daoGererEmpreintClassName);
            IDAOGererEmpreint dAOGererEmpreint = (IDAOGererEmpreint) daoEmpreintsClass.newInstance();
            
            Class businessEmpreintClass = Class.forName(className);
            serviceEmpreint = (BUsinessGererEmpreint) businessEmpreintClass.newInstance();
            serviceEmpreint.setDaoGererEmpreint(dAOGererEmpreint);
            listEmpreints = (ArrayList<Empreint>) serviceEmpreint.getAllEmpreints();
            
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MainControllerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEmpreints;
    }
    
}
