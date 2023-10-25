/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.bank;

import java.io.Serializable;

/**
 *
 * @author Cartel
 */

public class AccountDTO implements Serializable {

    Integer numeroCompte;
    TransactionDTO[] transactions;

    public Integer getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(Integer numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public TransactionDTO[] getTransactions() {
        return transactions;
    }

    public void setTransactions(TransactionDTO[] transactions) {
        this.transactions = transactions;
    }
    
    public double getSold(){
        TransactionDTO[] transactions = this.getTransactions();
        double currentSold = 0;
        for( TransactionDTO transaction : transactions ){
            double transaction_balance = transaction.getBalance();
            currentSold = currentSold + transaction_balance;
        }
        return currentSold;
    }
    
}
