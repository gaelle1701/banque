package com.banque.test;

import org.junit.jupiter.api.*;

import com.banque.dao.TitulaireDao;
import com.banque.dao.impl.TitulaireDaoImpl;
import com.banque.entity.Titulaire;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TitulaireTest {
	private TitulaireDao dao;
	TitulaireDao titulaireDao = new TitulaireDaoImpl();

//	@Test
//	@Order(1)
//	void testReadAllCount() {
//		//permet de verif si condition est vrai (muette) / si fausse (affiche erreur)
//        Assertions.assertEquals(10, titulaireDao.readAll().size());
//	}


//	@Test
//	@Order(3)
//	void testCreate() {
//		Titulaire titulaire = new Titulaire();
//		titulaire.setPrenom("John");
//		titulaire.setNom("Doe");
//		titulaire.setAdresse("36 Carioca Place");
//		titulaire.setCode_postal("93270");
//		int id = titulaireDao.create(titulaire);
//		Assertions.assertTrue(id > 0, "List not create");
//	}

//	@Test
//	@Order(2)
//	void testByCode() {
//		int code_titulaire = 11;
//		Titulaire titulaire = titulaireDao.getByCode(code_titulaire);
//		Assertions.assertEquals("John", titulaire.getPrenom());
//	}

//	@Test
//	@Order(4)
//	void testUpdate() {
//		int code = 11;
//		Titulaire titulaire = new Titulaire();
//		titulaire.setCode_titulaire(code);
//		titulaire.setNom("Doe");
//		titulaire.setPrenom("John");
//		titulaire.setAdresse("36 Carioca Place\n");
//		titulaire.setCode_postal("13004");
//		titulaireDao.update(titulaire);
//		Titulaire titulaire1 = titulaireDao.getByCode(code);
//		Assertions.assertEquals("13004", titulaire1.getCode_postal());
//	}

//	@Test
//	@Order(5)
//	void testDelete() {
//		int code =11;
//		Titulaire titulaire = new Titulaire();
//		titulaire.setCode_titulaire(code);
//		titulaireDao.delete(titulaire);
//		Titulaire titulaire2 = titulaireDao.getByCode(code);
//		Assertions.assertNull(titulaire2);
//    }
}
