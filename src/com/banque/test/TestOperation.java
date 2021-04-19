package com.banque.test;

import com.banque.dao.OperationDao;
import com.banque.dao.impl.OperationDaoImpl;
import com.banque.entity.Compte;
import com.banque.entity.CompteCourant;
import com.banque.entity.Operation;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestOperation {
    private OperationDao dao;
    OperationDao operationDao = new OperationDaoImpl();

    @Test
    @Order(1)
    void testReadAllCount() {
        //permet de verif si condition est vrai (muette) / si fausse (affiche erreur)
        Assertions.assertTrue(!operationDao.readAll().isEmpty());
    }


    @Test
    @Order(3)
    void testCreate() {
        Operation operation = operationDao.getByNumOp(50);
        operation.setMontant(200);
        int id = operationDao.create(operation);
        Assertions.assertTrue(id > 0, "List not create");
    }

    @Test
    @Order(2)
    void testByCode() {
        int num_operation = 42;
        Operation operation = operationDao.getByNumOp(num_operation);
        Assertions.assertEquals(1000f, operation.getMontant());
    }

    @Test
    @Order(4)
    void testUpdate() {
        int num_operation = 50;
        Operation operation = operationDao.getByNumOp(num_operation);
        operation.setMontant(20000);
        operationDao.update(operation);
        Operation operation1 = operationDao.getByNumOp(num_operation);
        Assertions.assertEquals(20000f, operation1.getMontant());
    }

    @Test
    @Order(5)
    void testDelete() {
        int num_compte = 50;
        Operation operation = new Operation();
        operation.setNum_op(num_compte);
        operationDao.delete(operation);
        Operation operation2 = operationDao.getByNumOp(num_compte);
        Assertions.assertNull(operation2);
    }
}
