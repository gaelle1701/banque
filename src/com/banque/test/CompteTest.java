package com.banque.test;

import com.banque.dao.impl.CompteDaoImpl;
import com.banque.entity.Compte;
import com.banque.entity.CompteCourant;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CompteTest {
	private CompteDaoImpl dao;
	CompteDaoImpl compteDao = new CompteDaoImpl();

	@Test
	@Order(1)
	void testReadAllCount() {
		//permet de verif si condition est vrai (muette) / si fausse (affiche erreur)
		Assertions.assertEquals(13, compteDao.readAll().size());
	}

	@Test
	@Order(2)
	void testCreate() {
		Compte compte = new Compte();
		compte.setNum_compte(90487);
		compte.setCode_type_compte("C");
		compte.setSolde_compte(1000f);
		compte.setCode_titulaire(2);
		int id = compteDao.create(compte);
		Assertions.assertNotNull(id > 0, "Titulaire not create");
	}


	@Test
	@Order(3)
	void testByCode() {
		Integer num_compte = 90487;
		Compte compte = compteDao.getByNum(num_compte);
		Assertions.assertEquals("C", compte.getCode_type_compte());
	}

	@Test
	@Order(4)
	void testUpdate() {
		int num_compte = 90487;
		Compte compte = new Compte();
		compte.setNum_compte(90487);
		compte.setCode_type_compte("C");
		compte.setSolde_compte(1001f);
		compte.setCode_titulaire(6);
		compteDao.update(compte);
		Compte compte1 = compteDao.getByNum(num_compte);
		Assertions.assertEquals(1001f, compte1.getSolde_compte());
	}

	@Test
	@Order(5)
	void testDeleteCompte() {
		int num_compte = 90487;
		Compte compte = new CompteCourant();
		compte.setNum_compte(num_compte);
		compteDao.delete(compte);
		Compte compte2 = compteDao.getByNum(num_compte);
		Assertions.assertNull(compte2);
	}

}
