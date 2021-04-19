package com.banque.test;

import com.banque.dao.CompteDao;
import com.banque.dao.OperationDao;
import com.banque.dao.impl.CompteDaoImpl;
import com.banque.dao.impl.OperationDaoImpl;
import com.banque.entity.Compte;
import com.banque.entity.Operation;
import com.banque.metier.BanqueMetier;
import com.banque.metier.impl.BanqueMetierImpl;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankTest {
    BanqueMetier banck = new BanqueMetierImpl();
    CompteDao compteDao = new CompteDaoImpl();

    @BeforeEach
    void setUp() {
        System.out.println("Setting it up!");
       // Compte compte = banck.consulterCompte(21433);
       // compteDao.delete(compte);
    }

//    @Test
//    @Order(1)
//    void testConsulterCompte() {
//        Compte compte = banck.consulterCompte(21433);
//        Assertions.assertNotNull(compte);;
//    }

//    @Test
//    @Order(2)
//    void testVersement() {
//        Compte compte = banck.consulterCompte(21433);
//        banck.verser(21433, 1888f);
//        Compte compte1 = compteDao.getByNum(compte.getNum_compte());
//        Assertions.assertEquals(
//                compte.getSolde_compte() + 1888,
//                compte1.getSolde_compte());
//    }

//    @Test
//    @Order(3)
//    void testRetrait() {
//        Compte compte = banck.consulterCompte(81898);
//        banck.retirer(81898, 1888f);
//
//        Compte compte1 = compteDao.getByNum(compte.getNum_compte());
//        Assertions.assertEquals(
//                compte.getSolde_compte() - 1888,
//                compte1.getSolde_compte());
//    }

//    @Test
//    @Order(4)
//    void testVirement() {
//        int montant = 1000;
//        Compte compteLast = banck.consulterCompte(81898);
//        banck.virement(60767, 81898, montant);
//        Compte compteNext = banck.consulterCompte(81898);
//        Assertions.assertEquals(
//                compteNext.getSolde_compte(),
//                compteLast.getSolde_compte() + 1000);
//    }

//    @Test
//    @Order(5)
//    void testReadOptionsList() {
//       List<Operation> operations = banck.listOperation(1000);
//        for (Operation operation: operations) {
//            System.out.println(operation);
//        }
//    }
}
