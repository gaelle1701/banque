package com.banque.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.banque.config.Database;
import com.banque.dao.CompteDao;
import com.banque.entity.Compte;
import com.banque.entity.Operation;
import com.banque.entity.TypeCompte;
import com.banque.utils.Utils;


public class CompteDaoImpl implements CompteDao {
    private Statement statement;
    private Connection connection;
    private Utils utils = new Utils();

    //Reprendre la connexion et créer statement
    public CompteDaoImpl() {
        try {
            this.connection = Database.getInstance().getConnection();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //methodes en contrat du CompteDAO
    @Override
    public int create(Compte compte) {
        try {
            String sql = "insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (?, ?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, compte.getNum_compte());
            statement.setString(2, compte.getCode_type_compte());
            statement.setFloat(3, compte.getSolde_compte());
            statement.setInt(4, compte.getCode_titulaire());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Une érreur c'est produite: create " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Compte> readAll() {
        String sql ="select * from compte";
        ArrayList<Compte> comptes = new ArrayList<>();
        ResultSet result = null;
        try {
            result = this.connection.createStatement().executeQuery(sql);
            while(result.next()) {
                Compte compte = new Compte();
                this.utils.extracted(compte, result);
                comptes.add(compte);
            }
        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return comptes;
    }

    @Override
    public Compte getByNum(int num_compte) {
        String sql = "select * from compte where num_compte = ?";
        Compte compte = new Compte();
        try {
            ResultSet result = null;
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, num_compte);
            result = statement.executeQuery();
            if(result.next()){
                this.utils.extracted(compte, result);
            }else{
                compte = null;
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            System.out.println("Erreur update : getByNum " + ex.getMessage());
        }
        return compte;
    }

    @Override
    public int update(Compte compte) {
        String sql ="update compte set code_type_compte = ?, solde_compte = ?, code_titulaire = ? where num_compte = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, compte.getCode_type_compte());
            statement.setFloat(2, compte.getSolde_compte());
            statement.setInt(3, compte.getCode_titulaire());
            statement.setInt(4, compte.getNum_compte());
            System.out.println("Updated for : " + compte);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur updated !" + ex.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(Compte compte) {
        String sql ="delete from compte where num_compte = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, compte.getNum_compte());
            System.out.println("Deleted for : " + compte);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur deleted ! " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Compte> getByTitulaire(int code_titulaire) {
        String sql ="SELECT c.*, tc.code_type_compte AS code_type, tc.intitule FROM compte c INNER JOIN type_compte tc ON c.code_type_compte = tc.code_type_compte WHERE c.code_titulaire = "+ code_titulaire+"";
        ArrayList<Compte> comptes = new ArrayList<>();
        ResultSet result;
        try {
            result = this.connection.createStatement().executeQuery(sql);
            while(result.next()) {
                Compte compte = new Compte();
                TypeCompte typeCompte = new TypeCompte();
                compte.setCode_titulaire(result.getInt("code_titulaire"));
                compte.setCode_type_compte(result.getString("code_type_compte"));
                compte.setNum_compte(result.getInt("num_compte"));
                compte.setSolde_compte(result.getFloat("solde_compte"));
                typeCompte.setCode_type_compte(result.getString("code_type_compte"));
                typeCompte.setIntitule(result.getString("intitule"));
                compte.setTypeCompte(typeCompte);
                comptes.add(compte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comptes;
    }
	

	@Override
    public Compte getByType(String code_type_compte, int code_titulaire) {
		String sql = "SELECT * FROM type_compte tc inner join compte c on tc.code_type_compte = c.code_type_compte"
				+ "where tc.code_type_compte = "+code_type_compte+" and c.code_titulaire = "+code_titulaire;
        Compte compte = new Compte();
        try {
            ResultSet result = null;
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1,  code_type_compte);
            result = statement.executeQuery();
            if(result.next()){
                this.utils.extracted(compte, result);
            }else{
                compte = null;
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            System.out.println("Erreur update : getByCompte " + ex.getMessage());
        }
        return compte;
       

	}
}

