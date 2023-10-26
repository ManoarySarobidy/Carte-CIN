/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.banque;

import dto.bank.AccountDTO;
import dto.bank.TransferDTO;
import java.io.Serializable;
import javax.ejb.Local;

/**
 *
 * @author Cartel
 */
@Local
public interface BanqueLocal extends Serializable {
        
    public AccountDTO getBankAccount(String cin) throws Exception ;
    public void transferer( TransferDTO transfer ) throws Exception;
}
