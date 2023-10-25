/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.module.banque;

import com.entity.banque.Account;
import com.entity.banque.Transfer;
import dto.bank.AccountDTO;
import dto.bank.TransferDTO;
import javax.ejb.Stateless;

/**
 *
 * @author Cartel
 */
@Stateless
public class BanqueService implements BanqueServiceRemote, BanqueLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public AccountDTO getBankAccount(String cin){
        
        Account account = new Account();
        account.setCin(cin);
        account = account.getByCin();
        AccountDTO accountDTO = account.toDto();
        return accountDTO;
        
    }
    
    // Ajouter une transaction banquaire
    // Inona daholo no ilaina
    // Mila atao aloha hoe alefa any ilay izy
    // Mila fonction maka ny cours de devise farany
    
    // Andao anao fonction ary
    @Override
    public void transferer(TransferDTO transfer) throws Exception{
        // Alefa any anaty classe Transfer io DTO io
        Transfer transfers = new Transfer(transfer);
        transfers.executeTransfer();
    }
    
    
}
