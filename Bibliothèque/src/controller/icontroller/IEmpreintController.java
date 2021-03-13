/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.icontroller;

import java.util.List;
import javafx.scene.layout.BorderPane;
import model.business.BUsinessGererEmpreint;
import model.entities.Empreint;
import model.iservicedao.IDAOGererEmpreint;

/**
 *
 * @author Makhlouf Helali
 */
public interface IEmpreintController {
    public void afficherEmpreintView(BorderPane root);
    public void ajouterEmpreint(BUsinessGererEmpreint businessEmpreint);
    public List<Empreint> getAllEmpreints();
}
