package com.banque.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.banque.dao.TitulaireDao;
import com.banque.dao.impl.TitulaireDaoImpl;
import com.banque.entity.Titulaire;


public class TitulaireTest {
	private TitulaireDao dao;
	TitulaireDao titulaireDao = new TitulaireDaoImpl();
	
	
	@Test
	void testReadAllCount() {
		
		//permet de verif si condition est vrai (muette) / si fausse (affiche erreur)
        Assertions.assertEquals(10, titulaireDao.readAll().size());	
	}
	
	
	@Test
	void testByCode() {
		int code = 7749;
		Titulaire titulaire = titulaireDao.getByCode(code);
		Assertions.assertEquals("Traci", titulaire.getPrenom());
	}
	 
	@Test
	void testCreate() {
		Titulaire titulaire = new Titulaire();
		titulaire.setCode(3764);
		titulaire.setPrenom("John");
		titulaire.setNom("Doe");
		titulaire.setAdresse("36 Carioca Place");
		titulaire.setCode_postal("93270");
		int id = titulaireDao.create(titulaire);
		Assertions.assertTrue(id > 0, "List not create");
	}
	
	@Test
	void testUpdate() {
		int code = 6754;
		Titulaire titulaire = new Titulaire();
		titulaire.setCode(code);
		titulaire.setNom("Lintall");
		titulaire.setPrenom("Georgie");
		titulaire.setAdresse("3 Judy Crossing");
		titulaire.setCode_postal("13002");
		titulaireDao.update(titulaire);
		Titulaire titulaire1 = titulaireDao.getByCode(code);
		Assertions.assertEquals("13002", titulaire1.getCode_postal());

	}
	
	@Test
		void testDelete() {
		int code = 3764;
		Titulaire titulaire = new Titulaire();
		titulaire.setCode(code);
		titulaireDao.delete(titulaire);
		int ret = titulaireDao.delete(titulaire);
		Titulaire titulaire3 = titulaireDao.getByCode(code);
		Assertions.assertNull(titulaire3);
    }

}
