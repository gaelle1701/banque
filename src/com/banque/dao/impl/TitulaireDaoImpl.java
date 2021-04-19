package com.banque.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.banque.config.Database;
import com.banque.dao.TitulaireDao;
import com.banque.entity.Titulaire;
import com.banque.utils.Utils;


public class TitulaireDaoImpl implements TitulaireDao{
	
	private Statement statement;
	private Connection connection;
	private Utils utils = new Utils();
	//Reprendre la connexion et créer statement
	public TitulaireDaoImpl() {
		try {
			this.connection = Database.getInstance().getConnection();
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}	
	}
	
	//methodes en contrat du TitulaireDAO
	@Override
    public int create(Titulaire titulaire) {
        try {
            String sql = "insert into titulaire (prenom, nom, adresse, code_postal) values (?, ?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, titulaire.getPrenom());
            statement.setString(2, titulaire.getNom());
            statement.setString(3, titulaire.getAdresse());
            statement.setString(4, titulaire.getCode_postal());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Une érreur c'est produite: create " + ex.getMessage());
        }
        return 0;
    }

	@Override
	public ArrayList<Titulaire> readAll() {
		//créa requête
		String sql ="select * from titulaire";
		//créa tab
		ArrayList<Titulaire> titulaires = new ArrayList<>();
		
		ResultSet result;
		
		try {
			result = this.connection.createStatement().executeQuery(sql);
			
			System.out.println("______________DAO IMPL ReadAll_______________");
			
			//tant que il y a un result => boucle sur le suivant
			while(result.next()) {
				
				//créa objet titulaire
				Titulaire titulaire = new Titulaire();
				
				// ajoute/modifie la valeur avec setter
				  titulaire.setCode_titulaire(result.getInt("code_titulaire"));
				  titulaire.setNom(result.getString("nom"));
				  titulaire.setPrenom(result.getString("prenom"));
				  titulaire.setAdresse(result.getString("adresse"));
				  titulaire.setCode_postal(result.getString("code_postal"));
				 		
				//utilise la méthode Utils
				//this.utils.extracted(titulaire, result);
								
				//ajoute titulaire ds tab
				titulaires.add(titulaire);
				
			}
		} catch (SQLException /*| NoSuchMethodException | InvocationTargetException | IllegalAccessException */ e) {			
			e.printStackTrace();
		}
		
		return titulaires;
	}

	@Override
	  public Titulaire getByCode(int code_titulaire) {
		
        String sql = "select * from titulaire where code_titulaire = ?";
        Titulaire titulaire = new Titulaire();
        
        try {
            ResultSet result = null;
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, code_titulaire);
            result = statement.executeQuery();
            
            if(result.next()){
                this.utils.extracted(titulaire, result);
            }else{
                titulaire = null;
            }
            
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            System.out.println("Erreur update : getByCode " + ex.getMessage());
        }
        
        return titulaire;
    }

	@Override
	public int update(Titulaire titulaire) {
		String sql ="update titulaire set prenom = ?, nom = ?, adresse = ?, code_postal = ? where code_titulaire = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, titulaire.getPrenom());
			statement.setString(2, titulaire.getNom());
			statement.setString(3, titulaire.getAdresse());
			statement.setString(4, titulaire.getCode_postal());
			statement.setInt(5, titulaire.getCode_titulaire());
			
			System.out.println("Updated for : " + titulaire);
			return statement.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("Erreur updated !" + ex.getMessage());
		}
		return 0;
	}

	@Override
	public int delete(Titulaire titulaire) {
		String sql ="delete from titulaire where code_titulaire = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, titulaire.getCode_titulaire());
			System.out.println("Deleted for : " + titulaire);
			return statement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erreur deleted ! " + ex.getMessage());
		}
		return 0;
		
	}

}
