package com.banque.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.banque.config.Database;
import com.banque.dao.TypeCompteDao;
import com.banque.entity.TypeCompte;
import com.banque.utils.Utils;


public class TypeCompteDaoImpl implements TypeCompteDao{
	
	private Statement statement;
	private Connection connection;
	private Utils utils = new Utils();
	

	public TypeCompteDaoImpl() {
		try {
			this.connection = Database.getInstance().getConnection();
			
		}catch(SQLException throwables) {
			throwables.printStackTrace();
			
		}	
	}
	

	@Override
    public int create(TypeCompte typeCompte) {
        try {
        	
            String sql = "insert into type_compte (code_type_compte, intitule) values (?, ?)";
            
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, typeCompte.getCode_type_compte());
            statement.setString(2, typeCompte.getIntitule());
            
            return statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Une érreur c'est produite: create " + ex.getMessage());
        }
        return 0;
    }

	@Override
	public ArrayList<TypeCompte> readAll() {
		String sql ="select * from type_compte";
		ArrayList<TypeCompte> typeComptes = new ArrayList<>();		
		ResultSet result;
		try {
			result = this.connection.createStatement().executeQuery(sql);

			while(result.next()) {

				TypeCompte typeCompte = new TypeCompte();
				
				 typeCompte.setCode_type_compte(result.getString("code_type_compte"));
				 typeCompte.setIntitule(result.getString("intitule"));		 		

				typeComptes.add(typeCompte);
				
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return typeComptes;
	}

	@Override
	  public TypeCompte getByType(String code_type_compte) {
		
        String sql = "select * from type_compte where code_type_compte = ?";
        TypeCompte typeCompte = new TypeCompte();
        
        try {
            ResultSet result = null;
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, code_type_compte);
            result = statement.executeQuery();
            
            if(result.next()){
                this.utils.extracted(typeCompte, result);
            }else{
                typeCompte = null;
            }
            
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            System.out.println("Erreur update : getByCode " + ex.getMessage());
        }
        
        return typeCompte;
    }

	@Override
	public int update(TypeCompte typeCompte) {
		String sql ="update type_compte set intitule = ? where code_type_compte = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, typeCompte.getIntitule());
			statement.setString(2, typeCompte.getCode_type_compte());
			
			System.out.println("Updated for : " + typeCompte);
			return statement.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("Erreur updated !" + ex.getMessage());
		}
		return 0;
	}

	@Override
	public int delete(TypeCompte typeCompte) {
		String sql ="delete from type_compte where code_type_compte = ?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, typeCompte.getCode_type_compte());
			
			System.out.println("Deleted for : " + typeCompte);
			return statement.executeUpdate();
				
		} catch (SQLException ex) {
			System.out.println("Erreur deleted ! " + ex.getMessage());
		}
		return 0;
		
	}

}