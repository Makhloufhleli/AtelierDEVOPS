/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.controllerimp;

import controller.icontroller.ILivreCOntroller;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableRow;
import javafx.scene.layout.BorderPane;
import model.business.BusinessGererLivre;
import model.entities.Exemplaire;
import model.entities.Livre;
import model.iservicedao.IDAOGererLivre;
import model.serviceimpdao.DAOImpGererLivre;
import view.iview.ILivreView;
import view.viewimp.LivreViewImp;

/**
 *
 * @author Makhlouf Helali
 */
public class LivreControllerImp implements ILivreCOntroller{

    private ILivreView livreView;
    private BusinessGererLivre serviceLivre;
    
    
    @Override
    public void afficherLivreView(BorderPane root) {
        String className = LivreViewImp.class.getName();
        try {
            
            Class livreViewClass = Class.forName(className);
            livreView = (ILivreView) livreViewClass.newInstance();
            
            ArrayList<Livre> listLivres = (ArrayList<Livre>) getAllLivres();
            livreView.afficherViewListLivres(root, listLivres);
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MainControllerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        livreView.getLivreView().getBtnAjouter().setOnAction(clickToAdd->{
            ajouterLivre(root);
        });
        
        livreView.getLivreView().getTableViewLivres().setRowFactory(tv->{
            TableRow<Livre> row = new TableRow<>();
            row.setOnMouseClicked(click->{
                if (click.getClickCount() == 1 && (! row.isEmpty()) ) {
                    Livre livre = row.getItem();
                    livreView.getLivreView().getBtnAjouter().setDisable(true);
                    livreView.getLivreView().getBtnModifier().setDisable(false);
                    livreView.getLivreView().getBtnAjouterExemplaire().setDisable(false);
                    
                    livreView.getLivreView().getTitreField().setText(livre.getTitre());
                    livreView.getLivreView().getThemeField().setText(livre.getTheme());
                    livreView.getLivreView().getIsbnField().setText(livre.getIsbn());
                    livreView.getLivreView().getAuteurField().setText(livre.getAuteur());
                    
                    
                    livreView.getLivreView().getBtnSupprimer().setDisable(false);
                    livreView.getLivreView().getBtnSupprimer().setOnAction(clickToDelete->{
                        List<Exemplaire> listExemplaires = serviceLivre.getLivreExemplaires(livre);
                        serviceLivre.supprimerLivre(livre, listExemplaires);
                        afficherLivreView(root);
                    });
                    
                    livreView.getLivreView().getBtnModifier().setOnAction(clickToEdit->{
                        int id = livre.getId();
                        String titre = livreView.getLivreView().getTitreField().getText();
                        String theme = livreView.getLivreView().getThemeField().getText();
                        String isbn = livreView.getLivreView().getIsbnField().getText();
                        String auteur = livreView.getLivreView().getAuteurField().getText();
                        Livre editedLiv = new Livre();
                        editedLiv.setId(id);editedLiv.setIsbn(isbn);editedLiv.setTitre(titre);editedLiv.setTheme(theme);editedLiv.setAuteur(auteur);
                        serviceLivre.modifierLivre(editedLiv);
                        afficherLivreView(root);

                    });
                    
                    livreView.getLivreView().getBtnAjouterExemplaire().setOnAction(clickToAddExemplaire->{
                        livreView.getLivreView().afficherViewAddExemplaire(root);
                    });
                    
                    livreView.getLivreView().getBtnEnregistrerExemplaire().setOnAction(clickToSaveExemplaire->{
                        String codeExemplaire = livreView.getLivreView().getExemplaireField().getText();
                        Exemplaire exemplaire = new Exemplaire();
                        exemplaire.setId(livre.getId());
                        exemplaire.setIsbn(livre.getIsbn());
                        exemplaire.setTitre(livre.getTitre());
                        exemplaire.setTheme(livre.getTheme());
                        exemplaire.setAuteur(livre.getAuteur());
                        exemplaire.setCodeExemplaire(codeExemplaire);
                        exemplaire.setEmpreinte(false);
                        if(serviceLivre.ajouterExemplaire(exemplaire))
                            System.out.println("exemplaire ajouté avec succès");
                        afficherLivreView(root);
                    });
                    
                    
                }
            });
            return row;
            
        });
        
    }

    @Override
    public void ajouterLivre(BorderPane root) {
        String titre = livreView.getLivreView().getTitreField().getText();
        String theme = livreView.getLivreView().getThemeField().getText();
        String isbn = livreView.getLivreView().getIsbnField().getText();
        String auteur = livreView.getLivreView().getAuteurField().getText();
        Livre livre = new Livre();
        livre.setTitre(titre);livre.setTheme(theme);livre.setIsbn(isbn);livre.setAuteur(auteur);
        if(serviceLivre.ajouterLivre(livre))
            System.out.println("livre ajouté avec succès!");
        
        afficherLivreView(root);
    }

    @Override
    public List<Livre> getAllLivres() {
        ArrayList<Livre> listLivres = new ArrayList();
        String className = BusinessGererLivre.class.getName();
        String daoGererLivreClassName = DAOImpGererLivre.class.getName();
        try {
            Class daoLivreClass = Class.forName(daoGererLivreClassName);
            IDAOGererLivre daoGererLivre = (IDAOGererLivre) daoLivreClass.newInstance();
            
            Class businessLivreClass = Class.forName(className);
            serviceLivre = (BusinessGererLivre) businessLivreClass.newInstance();
            serviceLivre.setDaoGererLivre(daoGererLivre);
            listLivres = (ArrayList<Livre>) serviceLivre.getAllLivres();
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MainControllerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLivres;
    }
    
}
