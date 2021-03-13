/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewimp;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.iview.IMainView;

/**
 *
 * @author Makhlouf Helali
 */
public class MainViewImp implements IMainView{

    private Button menuLivres = new Button("Livres");
    private Button menuEmpreints = new Button("Empreints");
    
    @Override
    public void afficherMainView(BorderPane root) {
        // sideBar and topBar background fill
        BackgroundFill background_fill = new BackgroundFill(Color.web("#5d4982"), CornerRadii.EMPTY, Insets.EMPTY);  
        Background background = new Background(background_fill);
        
        //logo
        Label logo = new Label("ESPRIM'S");
        logo.setStyle("-fx-font: 40 Verdana; -fx-text-fill: white;-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.8), 10, 0, 0, 0);");
        logo.prefWidthProperty().bind(root.widthProperty().divide(5));
        
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        //topBar
        HBox topBar = new HBox(logo, separator);
        topBar.setMinSize(0, 50);
        topBar.setBackground(background);
        
        //SideBar
        VBox sideBar = new VBox();
        sideBar.setPadding((new Insets(5, 5, 5, 5)));
        sideBar.setBackground(background);
        sideBar.prefWidthProperty().bind(root.widthProperty().divide(5));
        sideBar.setSpacing(5);
        
        menuEmpreints.setStyle("-fx-font: 20 Verdana; -fx-backgroung-fill: #007bff ; -fx-text-fill: black;-fx-border-radius: 30px; -fx-border-width: 2px; -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.8), 10, 0, 0, 0);");
        menuEmpreints.prefWidthProperty().bind(sideBar.widthProperty().divide(1));
        
        menuLivres.setStyle("-fx-font: 20 Verdana; -fx-backgroung-fill: #007bff ; -fx-text-fill: black;-fx-border-radius: 30px; -fx-border-width: 2px; -fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.8), 10, 0, 0, 0);");
        menuLivres.prefWidthProperty().bind(sideBar.widthProperty().divide(1));
        
        sideBar.getChildren().addAll(new Separator(), menuLivres, menuEmpreints);
        
        Image imageHome = new Image("file:src\\view\\livres.jpg");
        ImageView imageviewHome = new ImageView();
        imageviewHome.setImage(imageHome);
        //imageviewHome.setFitWidth(700 );
        //imageviewHome.setFitHeight(400);
        
        
        root.setLeft(sideBar);
        root.setCenter(imageviewHome);
        root.setTop(topBar);
    }

    @Override
    public MainViewImp getMainView() {
        return this;
    }

    public Button getMenuLivres() {
        return menuLivres;
    }

    public Button getMenuEmpreints() {
        return menuEmpreints;
    }
    
    
    
    
}
