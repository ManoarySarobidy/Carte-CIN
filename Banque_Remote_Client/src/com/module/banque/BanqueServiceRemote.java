/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.module.banque;

import dto.bank.AccountDTO;
import dto.bank.TransferDTO;
import java.io.Serializable;
import javax.ejb.Remote;

/**
 *
 * @author Cartel
*/

@Remote
public interface BanqueServiceRemote extends Serializable {
    public AccountDTO getBankAccount( String cin );
    public void transferer(TransferDTO transfer) throws Exception;
}
