/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business;

import java.util.List;
import model.entities.Empreint;
import model.iservicedao.IDAOGererEmpreint;

/**
 *
 * @author Makhlouf Helali
 */
public class BUsinessGererEmpreint {
    private Empreint empreint;
    
    private IDAOGererEmpreint daoGererEmpreint;

    public void setDaoGererEmpreint(IDAOGererEmpreint _daoGererEmpreint) {
        this.daoGererEmpreint = _daoGererEmpreint;
    }
    
    public boolean ajouterEmpreint(Empreint empreint){
        return daoGererEmpreint.ajouterEmpreint(empreint);
    }
    
    public List<Empreint> getAllEmpreints(){
        return daoGererEmpreint.getAllEmpreints();
    }
    
    public Empreint getEmpreintById(int id){
        return daoGererEmpreint.getEmpreintById(id);
    }
    
}
