package com.banque.entity;

import java.util.Date;

public class Retrait extends Operation {
	private static final String LIB_OP = "Retrait";
	public Retrait() {
		super();
	}

	public Retrait(float montant, Compte compte) {
		super(montant, LIB_OP, compte);
	}
	
}
