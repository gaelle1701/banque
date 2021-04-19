package com.banque.metier;

import com.banque.entity.Compte;
import com.banque.entity.Operation;
//import sun.jvm.hotspot.debugger.Page;

import java.util.List;


public interface BanqueMetier {
    public Compte consulterCompte(int num_compte);
    public void verser(int num_compte, float montant);
    public void retirer(int num_compte, float montant);
    public void virement(int num_compte1, int num_compte2, float montant);
    public List<Operation> listOperation(int num_compte);
}
