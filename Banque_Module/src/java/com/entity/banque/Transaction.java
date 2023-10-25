/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity.banque;

import dto.bank.TransactionDTO;
import java.sql.Connection;
import java.util.Date;
import java.sql.Timestamp;
import mine.generic.Dao;
import mine.generic.annotation.*;
/**
 *
 * @author Cartel
 */
@Table("transactions")
public class Transaction {
    
    @Column(value ="id_transaction", isPrimary = true, isSerial = true)
    Integer idTransaction;
    @Column("id_compte")
    Integer idCompte;
    @Column
    Double debit;
    @Column
    Double credit;
    @Column("date_transaction")
    Timestamp datetime;

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer id_transaction) {
        this.idTransaction = id_transaction;
    }

    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer id_compte) {
        this.idCompte = id_compte;
    }

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

    public Timestamp getDatetime() {
//        if( this.date == null ) this.setDate( new Timestamp( System.currentTimeMillis() ) );
//        System.out.println(this.date);
        return this.datetime;
    }

    public void setDatetime(Timestamp date) {
        //System.out.println(date);
        this.datetime = date;
    }
    
    public double getSold(){
        return this.getDebit() - this.getCredit();
    }
    
    public void exec( Connection connection ) throws Exception{
        System.out.println("Eto be fotsiny ara hoe (1) ");
//        try{
        Timestamp t = new Timestamp(new Date().getTime());
        this.setDatetime( new Timestamp( System.currentTimeMillis() ) );
        System.out.println( new Date().getTime() );
        Dao.save(connection, this);
//        }catch(Exception e){
//            System.out.println("Ato exception transaction zao");
//            System.out.println("Ato exception transaction zao");
//            e.printStackTrace();
//            throw e;
//        }
    }
    
    public TransactionDTO toDto(){
        TransactionDTO dto = new TransactionDTO();
        dto.setCredit(this.getCredit());
        dto.setDebit(this.getDebit());
        dto.setDate(this.getDatetime());
        return dto;
    }
    
    // Inona no atao eto manao conversion
    
}
