/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.bank;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Cartel
 */
public class TransactionDTO implements Serializable {
    
    Double debit;
    Double credit;
    Timestamp date;

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    public double getBalance(){
        return this.getDebit() - this.getCredit();
    }
      
}
