package com.banque.entity;

import java.sql.Date;
public class Versement extends Operation {
	private static final String LIB_OP = "Versement";
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(float montant, Compte compte) {
		super(montant, LIB_OP, compte);
		// TODO Auto-generated constructor stub
	}


}
