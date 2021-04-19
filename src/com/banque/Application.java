package com.banque;

import com.banque.dao.CompteDao;
import com.banque.dao.OperationDao;
import com.banque.dao.TitulaireDao;
import com.banque.dao.TypeCompteDao;
import com.banque.dao.impl.CompteDaoImpl;
import com.banque.dao.impl.OperationDaoImpl;
import com.banque.dao.impl.TitulaireDaoImpl;
import com.banque.dao.impl.TypeCompteDaoImpl;
import com.banque.entity.Compte;
import com.banque.entity.Operation;
import com.banque.entity.Titulaire;
import com.banque.entity.TypeCompte;

import java.text.NumberFormat;
import java.util.ArrayList;


public class Application {

	public static void main(String[] args) {
	TitulaireDao titulaireDao = new TitulaireDaoImpl();
	CompteDao compteDao = new CompteDaoImpl();
	OperationDao operationDao = new OperationDaoImpl();
	TypeCompteDao typeCompteDao = new TypeCompteDaoImpl();
	Titulaire inkles = titulaireDao.getByCode(10);
		
	ArrayList<Compte> inklesListComptes = compteDao.getByTitulaire(inkles.getCode_titulaire());
		
		 String AlignFormatTitulaire = "|  %-8d       | %-10s       |   %-13s   |  %-14s  |%n";
	        System.out.println("_______Titulaire_______");
	        System.out.format("+-----------------+---------------------------------------------------------+%n");
	        System.out.format("| Code titulaire  | Nom              |   Prenom          |  Code Postal     |%n");
	        System.out.format("+-----------------+---------------------------------------------------------+%n");
	        System.out.format(AlignFormatTitulaire, inkles.getCode_titulaire(), inkles.getNom() ,inkles.getPrenom(), inkles.getCode_postal());
	        System.out.format("+-----------------+---------------------------------------------------------+%n");
	        		
	        for (Compte compte : inklesListComptes) {
	        	ArrayList<Operation> inklesListOpes = operationDao.getByNumCompte(compte.getNum_compte());		
	        	System.out.println("_____"+compte.getTypeCompte().getIntitule()+"_____");
	        	String AlignFormatTitulaireCompte = "|  %-8d       | %-10s       |   %-13f   |  %-14s  |%n";
	        	System.out.format("+-----------------+---------------------------------------------------------+%n");
	        	System.out.format("| Code compte     | Code Type        |   Solde           |  Nom Titulaire   |%n");
	        	System.out.format("+-----------------+---------------------------------------------------------+%n");
	        	System.out.format(AlignFormatTitulaireCompte, compte.getNum_compte(),
					compte.getCode_type_compte(), compte.getSolde_compte(), inkles.getNom());
	        	System.out.format("+-----------------+---------------------------------------------------------+%n");
			
	        	System.out.println("______Opérations_______");
	        		for (Operation operation : inklesListOpes) {				
	        			String AlignFormatOperationCompte = "|  %-8d       | %-8s       |   %-13s   |  %-16s  |  %-18f  |%n";
	        			System.out.format("+-----------------+--------------------------------------------------------------------------------+%n");
	        			System.out.format("| Num opération   |  Compte        |   Date            |  Libellé           | Montant              |%n");
	        			System.out.format("+-----------------+--------------------------------------------------------------------------------+%n");
	        			System.out.format(AlignFormatOperationCompte, operation.getNum_op(), operation.getNum_compte(),
	        					operation.getDate_op(), operation.getLib_op(), operation.getMontant());
	        			System.out.format("+-----------------+--------------------------------------------------------------------------------+%n");

			}
		}
	
	}
}
