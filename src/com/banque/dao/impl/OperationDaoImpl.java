package com.banque.dao.impl;

import com.banque.config.Database;
import com.banque.dao.OperationDao;
import com.banque.entity.Operation;
import com.banque.utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;


public class OperationDaoImpl implements OperationDao{

	private Statement statement;
	private Connection connection;
	private Utils utils = new Utils();

	//Reprendre la connexion et créer statement
	public OperationDaoImpl() {
		try {
			this.connection = Database.getInstance().getConnection();

		}catch(SQLException throwables) {
			throwables.printStackTrace();

		}
	}

	//methodes en contrat du OperationDAO
	@Override
	public int create(Operation operation) {
		try {
			String sql = "insert into operation(num_compte, date_op, lib_op, montant, type_op) values (?, ?, ?, ?, ?)";

			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, operation.getNum_compte());
			statement.setDate(2, operation.getDate_op());
			statement.setString(3, operation.getLib_op());
			statement.setFloat(4, operation.getMontant());
			statement.setString(5, operation.getType_op());
			System.out.println(operation);
			return statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("Une érreur c'est produite: create " + ex.getMessage());
		}
		return 0;
	}

	@Override
	public ArrayList<Operation> readAll() {
		String sql ="select * from operation";
		ArrayList<Operation> operations = new ArrayList<>();
		ResultSet result;
		try {
			result = this.connection.createStatement().executeQuery(sql);
			while(result.next()) {
				Operation operation = new Operation();
				this.utils.extracted(operation, result);
				operations.add(operation);
			}
		} catch (SQLException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return operations;
	}

	@Override
	public Operation getByNumOp(int num_op) {
		String sql = "select * from operation where num_op = ?";
		Operation operation = new Operation();
		try {
			ResultSet result = null;
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, num_op);
			result = statement.executeQuery();
			if(result.next()){
				this.utils.extracted(operation, result);
			}else{
				operation = null;
			}
		} catch (SQLException | NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
			System.out.println("Erreur update : getByNumOp " + ex.getMessage());
		}
		return operation;
	}

	@Override
	public int update(Operation operation) {
		String sql ="update operation set num_compte = ?, date_op = ?, lib_op = ?, montant = ?, type_op = ? where num_op = ?";

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, operation.getNum_compte());
			statement.setDate(2, operation.getDate_op());
			statement.setString(3, operation.getLib_op());
			statement.setFloat(4, operation.getMontant());
			statement.setString(5, operation.getType_op());
			statement.setInt(6, operation.getNum_op());

			System.out.println("Updated for : " + operation);
			return statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("Erreur updated !" + ex.getMessage());
		}
		return 0;
	}

	@Override
	public int delete(Operation operation) {
		String sql ="delete from operation where num_op = ?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, operation.getNum_op());
			System.out.println("Deleted for : " + operation);
			return statement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erreur deleted ! " + ex.getMessage());
		}
		return 0;
	}

	@Override
    public ArrayList<Operation> getByNumCompte(int num_compte) {
        String sql ="select * from operation where num_compte = "+ num_compte;
        ArrayList<Operation> operations = new ArrayList<>();
        ResultSet result;
        try {
            result = this.connection.createStatement().executeQuery(sql);
            while(result.next()) {
                Operation operation = new Operation();
                this.utils.extracted(operation, result);
                operations.add(operation);
            }
        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return operations;
    }

}
