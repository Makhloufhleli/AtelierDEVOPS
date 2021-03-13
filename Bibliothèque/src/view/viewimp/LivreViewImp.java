/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewimp;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Livre;
import view.iview.ILivreView;

/**
 *
 * @author Makhlouf Helali
 */
public class LivreViewImp implements ILivreView{

    //Conteiners
    private TableView<Livre> tableViewLivres = new TableView();
    private VBox container = new VBox();
    
    //Buttons
    private Button btnAjouter = new Button("Ajouter");
    private Button btnModifier = new Button("Modifier");
    private Button btnSupprimer = new Button("Supprimer");
    private Button btnAjouterExemplaire = new Button("Ajouter exemplaire");
    private Button btnEnregistrerExemplaire = new Button("Enregistrer");
    
    
    //Fields
    private TextField titreField = new TextField();
    private TextField isbnField = new TextField();
    private TextField themeField = new TextField();
    private TextField auteurField = new TextField();
    private TextField exemplaireField = new TextField();
    
    
    @Override
    public void afficherViewListLivres(BorderPane root, ArrayList<Livre> listLivres) {
        ObservableList<Livre> livres =  FXCollections.observableArrayList();
        
        listLivres.forEach(livre->{
            livres.add(livre);
        });
        
        
        
        TableColumn<Livre, Integer> themeColumn = new TableColumn<>("Thème");
        themeColumn.prefWidthProperty().bind(tableViewLivres.widthProperty().divide(4));
        themeColumn.setCellValueFactory(new PropertyValueFactory<>("theme"));
        
        TableColumn<Livre, String> isbnColumn = new TableColumn<>("ISBN");
        isbnColumn.prefWidthProperty().bind(tableViewLivres.widthProperty().divide(4));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        
        TableColumn<Livre, String> titreColumn = new TableColumn<>("Titre");
        titreColumn.prefWidthProperty().bind(tableViewLivres.widthProperty().divide(4));
        titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
        
        
        TableColumn<Livre, String> auteurColumn = new TableColumn<>("Auteur");
        auteurColumn.prefWidthProperty().bind(tableViewLivres.widthProperty().divide(4));
        auteurColumn.setCellValueFactory(new PropertyValueFactory<>("auteur"));
        
        tableViewLivres.setItems(livres);
        
        tableViewLivres.getColumns().addAll(isbnColumn, titreColumn, themeColumn, auteurColumn);
        
        
        
        ScrollPane scroll = new ScrollPane();
        scroll.prefWidthProperty().bind(root.widthProperty().divide(1));
        scroll.setContent(tableViewLivres);
        tableViewLivres.prefWidthProperty().bind(scroll.widthProperty().divide(1));
        container.prefWidthProperty().bind(root.widthProperty().divide(1));
        
        container.getChildren().add(scroll);
        root.setCenter(container);
        
        afficherViewAddLivre(root);
    }

    @Override
    public void afficherViewAddLivre(BorderPane root) {
        
        
        HBox buttonsBox = new HBox(btnAjouter, btnModifier, btnSupprimer, btnAjouterExemplaire);
        GridPane fields = new GridPane();
        buttonsBox.setPadding(new Insets(20,20,20,20));
        
        btnModifier.setDisable(true);
        btnSupprimer.setDisable(true);
        btnAjouterExemplaire.setDisable(true);
        
        fields.setHgap(5);
        fields.setVgap(5);
        fields.setPadding(new Insets(20,20,20,20));
        fields.prefWidthProperty().bind(container.widthProperty().divide(1));
        titreField.setPrefColumnCount(14);
        
        VBox colTitre = new VBox(new Label("Titre"), titreField);
        VBox colTheme = new VBox(new Label("Thème"), themeField);
        VBox colIsbn = new VBox(new Label("ISBN"), isbnField);
        VBox colAuteur = new VBox(new Label("Auteur"), auteurField);
        fields.add(colTitre, 0, 1); fields.add(colTheme, 1, 1);
        fields.add(colIsbn, 2, 1); fields.add(colAuteur, 3, 1);
        fields.add(buttonsBox, 4, 1);
        
        
        
        
        container.getChildren().addAll(fields);
        
        root.setRight(null);
    }
    
    @Override
    public void afficherViewAddExemplaire(BorderPane root){
        
        HBox fieldsExemplaire = new HBox(new Label("No Exemplaire"), exemplaireField, btnEnregistrerExemplaire);
        fieldsExemplaire.setPadding(new Insets(20,20,20,20));
        container.getChildren().add(fieldsExemplaire);
    }

    @Override
    public LivreViewImp getLivreView() {
        return this;
    }

    public TableView<Livre> getTableViewLivres() {
        return tableViewLivres;
    }

    public TextField getTitreField() {
        return titreField;
    }

    public VBox getContainer() {
        return container;
    }

    public Button getBtnAjouter() {
        return btnAjouter;
    }

    public Button getBtnModifier() {
        return btnModifier;
    }

    public Button getBtnSupprimer() {
        return btnSupprimer;
    }

    public TextField getIsbnField() {
        return isbnField;
    }

    public TextField getThemeField() {
        return themeField;
    }

    public TextField getAuteurField() {
        return auteurField;
    }

    public Button getBtnAjouterExemplaire() {
        return btnAjouterExemplaire;
    }

    public Button getBtnEnregistrerExemplaire() {
        return btnEnregistrerExemplaire;
    }

    public TextField getExemplaireField() {
        return exemplaireField;
    }
    
    
    
}
