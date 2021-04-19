package com.banque.dao;

import com.banque.entity.Operation;

import java.time.LocalDate;
import java.util.ArrayList;

public interface OperationDao {
	public int create(Operation operation);
	public ArrayList<Operation> readAll();
	public Operation getByNumOp(int num_op);
	public int update(Operation operation);
	public int delete(Operation operation);
	public ArrayList<Operation> getByNumCompte(int num_compte);

}
