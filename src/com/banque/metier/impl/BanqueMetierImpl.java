package com.banque.metier.impl;

import com.banque.dao.CompteDao;
import com.banque.dao.OperationDao;
import com.banque.dao.impl.CompteDaoImpl;
import com.banque.dao.impl.OperationDaoImpl;
import com.banque.entity.*;
import com.banque.metier.BanqueMetier;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class BanqueMetierImpl implements BanqueMetier {

    private CompteDao compteDao;
    private OperationDao operationDao;

    public BanqueMetierImpl() {
        compteDao = new CompteDaoImpl();
        operationDao = new OperationDaoImpl();
    }

    @Override
    public Compte consulterCompte(int num_compte) {
        Optional<Compte> compte = Optional.ofNullable(compteDao.getByNum(num_compte));
        if(!compte.isPresent()) throw new RuntimeException("Compte introuvable");
        return compte.get();
    }

    @Override
    public void verser(int num_compte, float montant) {
        Compte compte = consulterCompte(num_compte);
        Versement v = new Versement(montant, compte);
        operationDao.create(v);
        compte.setSolde_compte(compte.getSolde_compte()+montant);
        compteDao.update(compte);
    }

    @Override
    public void retirer(int num_compte, float montant) {
        Compte compte = consulterCompte(num_compte);
        if(compte instanceof CompteCourant){
            float decouverts = ((CompteCourant) compte).getDecouvert();
            if(compte.getSolde_compte()+decouverts<montant) {
                throw new RuntimeException("Solde insuffisant");
            }
        }
        Retrait retrait = new Retrait(montant, compte);
        operationDao.create(retrait);
        compte.setSolde_compte(compte.getSolde_compte()-montant);
        compteDao.update(compte);
    }

    @Override
    public void virement(int num_compte1, int num_compte2, float montant) {
        retirer(num_compte1, montant);
        verser(num_compte2, montant);
    }

    @Override
    public List<Operation> listOperation(int num_compte) {
        List<Operation> operations = operationDao.readAll();
        return operations;
    }

}
