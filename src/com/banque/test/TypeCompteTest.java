package com.banque.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.banque.dao.TypeCompteDao;
import com.banque.dao.impl.TypeCompteDaoImpl;
import com.banque.entity.TypeCompte;

public class TypeCompteTest {
	private TypeCompteDao dao;
	TypeCompte typeCompte = new TypeCompte();
	TypeCompteDao typeCompteDao = new TypeCompteDaoImpl();

//	@Test
//	void testReadAllCount() {
//		
//        Assertions.assertEquals(4, typeCompteDao.readAll().size());	
//	}
	


//	@Test
//	void testByCode() {
//		String code_type = "A";
//		TypeCompte typeCompte = typeCompteDao.getByType(code_type);
//		Assertions.assertEquals("Assurance_vie", typeCompte.getIntitule());
//		
//	}


//	@Test
//	void testCreate() {
//		TypeCompte typeCompte = new TypeCompte();
//		typeCompte.setCode_type_compte("L");
//		typeCompte.setIntitule("Livré jeune");
//		int id = typeCompteDao.create(typeCompte);
//		Assertions.assertTrue(id > 0, "List not create");
//	}

	
//	@Test
//	void testUpdate() {
//		String code_type = "L";
//		TypeCompte typeCompte = new TypeCompte();
//		typeCompte.setCode_type_compte("L");
//		typeCompte.setIntitule("LoL");
//		typeCompteDao.update(typeCompte);
//		TypeCompte typeCompte1 = typeCompteDao.getByType(code_type);
//		//System.out.println("test "+ typeCompte1);
//		Assertions.assertEquals("L", typeCompte1.getCode_type_compte());
//
//	}

//	@Test
//		void testDelete() {
//		 	String code_type = "L";
//	        TypeCompte typeCompte = new TypeCompte();
//	        typeCompte.setCode_type_compte("L");
//	        typeCompteDao.delete(typeCompte);
//	        TypeCompte typeCompte1 = typeCompteDao.getByType(code_type);
//	        Assertions.assertNull(typeCompte1);
//    }
}
