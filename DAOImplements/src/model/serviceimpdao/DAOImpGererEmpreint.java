/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.entities.Empreint;
import model.entities.Etudiant;
import model.entities.Exemplaire;
import model.entities.Livre;
import model.factory.DbConnection;
import model.iservicedao.IDAOGererEmpreint;

/**
 *
 * @author Makhlouf Helali
 */
public class DAOImpGererEmpreint implements IDAOGererEmpreint{

    private DbConnection dbConnection;
    private final Connection conn = dbConnection.getInstance();
    
    @Override
    public boolean ajouterEmpreint(Empreint empreint) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empreint> getAllEmpreints() {
        ArrayList<Empreint> listEmpreints = new ArrayList();
        
        try {
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM empreint";
            ResultSet rs = stmt.executeQuery(req);
            
            if (stmt.execute(req)) {
                rs = stmt.getResultSet();
                while(rs.next()){
                    int empreintId = rs.getInt("id");
                    int etudiantId = rs.getInt("etudiant_id");
                    int exemplaireId = rs.getInt("exemplaire_id");
                    Date dateEmpreint = rs.getDate("date_empreint");
                    Date dateRetour = rs.getDate("date_retour");
                    
                    Empreint empreint = new Empreint();
                    empreint.setId(empreintId);
                    empreint.setDateEmpreint(dateEmpreint);
                    empreint.setDateRetour(dateRetour);
                    empreint.getEtudiants().add(getEmpreintEtudiant(empreint));
                    empreint.getExemplaires().add(getEmpreintExemplaire(empreint));
                    listEmpreints.add(empreint);
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listEmpreints;
    }

    @Override
    public Empreint getEmpreintById(int id) {
        Empreint empreint = null;
        try {
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM empreint WHERE id ='"+id+"';";
            ResultSet rs = stmt.executeQuery(req);
            
            if (stmt.execute(req)) {
                rs = stmt.getResultSet();
                while(rs.next()){
                    int empreintId = rs.getInt("id");
                    String prenom = rs.getString("prenom");
                    String nom = rs.getString("nom");
                    empreint = new Empreint();
                    
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empreint;
    }

    @Override
    public Etudiant getEmpreintEtudiant(Empreint empreint) {
        Etudiant etudiant = null;
        try {
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM empreint e, etudiant et WHERE e.etudiant_id = et.id AND e.id ='"+empreint.getId()+"';";
            ResultSet rs = stmt.executeQuery(req);
            
            if (stmt.execute(req)) {
                rs = stmt.getResultSet();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String prenom = rs.getString("prenom");
                    String nom = rs.getString("nom");
                    etudiant = new Etudiant();
                    etudiant.setId(id);etudiant.setPrenom(prenom);etudiant.setNom(nom);
                    
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etudiant;
    }

    @Override
    public Exemplaire getEmpreintExemplaire(Empreint empreint) {
        Exemplaire exemplaire = null;
        try {
            Statement stmt = conn.createStatement();
            String req = "SELECT * FROM empreint e, exemplaire ex WHERE e.exemplaire_id = ex.id  and e.id ='"+empreint.getId()+"';";
            ResultSet rs = stmt.executeQuery(req);
            
            if (stmt.execute(req)) {
                rs = stmt.getResultSet();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String isbn = rs.getString("isbn");
                    String titre = rs.getString("titre");
                    String theme = rs.getString("theme");
                    String auteur = rs.getString("auteur");
                    String code = rs.getString("code_exemplaire");
                    
                    exemplaire = new Exemplaire();
                    exemplaire.setId(id);exemplaire.setIsbn(isbn);exemplaire.setTitre(titre);
                    exemplaire.setTheme(theme);exemplaire.setAuteur(auteur);exemplaire.setCodeExemplaire(code);
                    
                    
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exemplaire;
    }
    
}
