/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entities.Exemplaire;
import model.entities.Livre;
import model.factory.DbConnection;
import model.iservicedao.IDAOGererLivre;

/**
 *
 * @author Makhlouf Helali
 */
public class DAOImpGererLivre implements IDAOGererLivre{

    private DbConnection dbConnection;
    private final Connection conn = dbConnection.getInstance();
    
    @Override
    public boolean ajouterLivre(Livre livre) {
        boolean success = false;
        try{
            String query = " insert into livre (isbn, titre, theme, auteur) values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, livre.getIsbn());
            preparedStmt.setString (2, livre.getTitre());
            preparedStmt.setString (3, livre.getTheme());
            preparedStmt.setString (4, livre.getAuteur());
            if(preparedStmt.execute())
                success = true;
            success = false;
        
        }catch(Exception e){
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public List<Livre> getAllLivres() {
        ArrayList<Livre> listLivres = new ArrayList();
        
        try {
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM livre";
            ResultSet rs = stmt.executeQuery(req);
            
            if (stmt.execute(req)) {
                rs = stmt.getResultSet();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String isbn = rs.getString("isbn");
                    String titre = rs.getString("titre");
                    String theme = rs.getString("theme");
                    String auteur = rs.getString("auteur");
                    
                    Livre l = new Livre();
                    l.setId(id);l.setIsbn(isbn);l.setTitre(titre);l.setTheme(theme);l.setAuteur(auteur);
                    listLivres.add(l);
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listLivres;
    }

    @Override
    public Livre getLivreByIsbn(String isbn) {
        Livre livre = null;
        try {
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM livre WHERE livre.isbn='"+isbn+"';";
            ResultSet rs = stmt.executeQuery(req);
            
            if (stmt.execute(req)) {
                rs = stmt.getResultSet();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String isbnl = rs.getString("isbn");
                    String titre = rs.getString("titre");
                    String theme = rs.getString("theme");
                    String auteur = rs.getString("auteur");
                    
                    livre = new Livre();
                    livre.setId(id);livre.setIsbn(isbnl);livre.setTitre(titre);livre.setTheme(theme);livre.setAuteur(auteur);
                    
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return livre;
    }

    @Override
    public void supprimerLivre(Livre livre, List<Exemplaire> listExemplaires) {
        int idLivre = livre.getId();
        
        try{
            String query = " DELETE FROM livre WHERE livre.id = "+idLivre;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            
            if(listExemplaires.size()>0){
                listExemplaires.forEach(exemplaire->{
                    String req = "DELETE FROM exemplaire WHERE exemplaire.isbn = '"+livre.getIsbn()+"';";
                    
                    try {
                        PreparedStatement preparedStmt1 = conn.prepareStatement(req);
                        preparedStmt1.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(DAOImpGererLivre.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void modifierLivre(Livre livre) {
        try{
            String query = "UPDATE livre SET isbn = '"+livre.getIsbn()+"', titre = '"+livre.getTitre()+"', theme = '"+livre.getTheme()+"', auteur = '"+livre.getAuteur()+"' WHERE id = '"+livre.getId()+"';";
            
            System.out.println(query);
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            
            preparedStmt.executeUpdate();
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean ajouterExemplaire(Exemplaire exemplaire) {
        boolean success = false;
        try{
            String query = " insert into exemplaire (isbn, titre, theme, auteur, code_exemplaire, empreinte) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, exemplaire.getIsbn());
            preparedStmt.setString (2, exemplaire.getTitre());
            preparedStmt.setString (3, exemplaire.getTheme());
            preparedStmt.setString (4, exemplaire.getAuteur());
            preparedStmt.setString (5, exemplaire.getCodeExemplaire());
            preparedStmt.setBoolean(6, exemplaire.isEmpreinte());
            if(preparedStmt.execute())
                success = true;
        
        }catch(Exception e){
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public List<Exemplaire> getLivreExemplaires(Livre livre) {
        ArrayList<Exemplaire> listExemplaires = new ArrayList();
        int idLivre = livre.getId();
        
        try {
            Statement stmt = conn.createStatement();
            String request = "SELECT * FROM livre l, exemplaire e WHERE l.isbn = e.isbn AND l.id ="+idLivre;
            ResultSet rs = stmt.executeQuery(request);
            
            if (stmt.execute(request)) {
                rs = stmt.getResultSet();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String isbn = rs.getString("isbn");
                    String titre = rs.getString("titre");
                    String theme = rs.getString("theme");
                    String auteur = rs.getString("auteur");
                    String code = rs.getString("code_exemplaire");
                    
                    Exemplaire exemplaire = new Exemplaire();
                    exemplaire.setId(id);exemplaire.setIsbn(isbn);exemplaire.setTitre(titre);
                    exemplaire.setTheme(theme);exemplaire.setAuteur(auteur);exemplaire.setCodeExemplaire(code);
                    listExemplaires.add(exemplaire);
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listExemplaires;
    }
    
}
