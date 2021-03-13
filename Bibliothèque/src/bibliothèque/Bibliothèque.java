/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothèque;

import controller.controllerimp.MainControllerImp;
import controller.icontroller.IMainController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Makhlouf Helali
 */
public class Bibliothèque extends Application {
    
    private BorderPane root = new BorderPane();
    
    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        
        Scene scene = new Scene(root, 1350, 650);
        
        primaryStage.setTitle("Bibliothèque");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        String className = MainControllerImp.class.getName();
        Class mainControllerClass = Class.forName(className);
        IMainController mainController = (IMainController) mainControllerClass.newInstance();
        mainController.afficherMainView(root);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
