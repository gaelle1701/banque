package com.banque.entity;

//import javafx.scene.input.KeyCode;
import java.sql.Date;

public class Operation {
	private Integer num_op;  // car objet null à la créa
	private Integer num_compte;
	private java.sql.Date date_op;
	private String lib_op;
	private float montant;
	private String type_op;
	private Compte compte;

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Operation() {}

	public Operation(float montant, String lib_op, Compte compte) {
		this.compte = compte;
		this.num_compte = compte.getNum_compte();
		this.date_op = new Date(System.currentTimeMillis());
		this.lib_op = lib_op;
		this.montant = montant;
		this.type_op = lib_op.substring(0, 1).toUpperCase();
	}


	public Integer getNum_op() {
		return num_op;
	}

	public void setNum_op(Integer num_op) {
		this.num_op = num_op;
	}

	public Integer getNum_compte() {
		return num_compte;
	}

	public void setNum_compte(Integer num_compte) {
		this.num_compte = num_compte;
	}

	public Date getDate_op() {
		return date_op;
	}

	public void setDate_op(Date date_op) {
		this.date_op = date_op;
	}

	public String getLib_op() {
		return lib_op;
	}

	public void setLib_op(String lib_op) {
		this.lib_op = lib_op;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getType_op() {
		return String.valueOf(type_op);
	}

	public void setType_op(String type_op) {
		this.type_op = type_op;
	}

	@Override
	public String toString() {
		return "Operation{" +
				"num_op=" + num_op +
				", num_compte=" + num_compte +
				", date_op=" + date_op +
				", lib_op='" + lib_op + '\'' +
				", montant=" + montant +
				", type_op='" + type_op + '\'' +
				'}';
	}


}


