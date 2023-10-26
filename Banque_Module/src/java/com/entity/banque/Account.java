/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity.banque;

import dto.bank.AccountDTO;
import dto.bank.TransactionDTO;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Vector;
import mine.generic.Dao;
import mine.generic.annotation.*;
import sql.Connect;
/**
 *
 * @author Cartel
 */
@Table("account")
public class Account {
    
    @Column(value="id", isPrimary = true, isSerial = true)
    Integer idAccount;
    @Column("numero_compte")
    Integer accountNumber;
    @Column
    String cin;
    
    Transaction[] transactions;
    

/** Getters and setters */
    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    
    // Mila aseho daholo ny momba azy rehetra
    
    public Account getByCin() throws Exception {
        String sql = "select * from account where cin = '" + this.getCin() + "'";
        // Okey de rehefa azo iny de mila alaina ihany koa ny transaction mifanaraka aminy
        Connect c = new Connect();
        Connection con = c.getPostgres();
        Account account = Dao.find(con, sql, this);
        account.setUpTransaction(con);
        con.close();
        return account;
    }
    
    void setUpTransaction( Connection connection ) throws Exception{
        String sql = "select * from transactions where id_compte = '" + this.getIdAccount() + "'";
        try{
            Vector<Transaction> transaction = Dao.findAll(connection, new Transaction(), sql);
            this.setTransactions( transaction.toArray( new Transaction[ transaction.size() ] ) );
        }catch(Exception e){
            // e.printStackTrace();
            System.out.println("Error when setting up transactions : " + e.getMessage());
            throw e;
        }
    }
    
    public void setTransactions( Transaction[] transactions ){
        this.transactions = transactions;
    }
    
    public Transaction[] getTransaction(){
        return this.transactions;
    }
    
    public double getSold(){
        Transaction[] tr = this.getTransaction();
        double currentSold = 0;
        for( Transaction t : tr ){
            double transaction_sold = t.getSold();
            currentSold = currentSold + transaction_sold;
        }
        return currentSold;
    }
    
    public AccountDTO toDto(){
        AccountDTO dto = new AccountDTO();
        dto.setNumeroCompte(this.getAccountNumber());
        TransactionDTO[] dtos = new TransactionDTO[ this.getTransaction().length ];
        for( int i = 0; i < this.getTransaction().length; i++ ){
            dtos[i] = this.getTransaction()[i].toDto();
        }
        dto.setTransactions(dtos);
        return dto;
    }
    // Technique hafa anaovana insertion izao
    
    public boolean canSend( double montant, double devise ) throws Exception{
//        Connection connection = new Connect().getPostgres();
//        montant en devise ===> devise === montant en (Ariary) pour le devise
//        50 $ ===========> 3000 ar =====> 50$ * 3000 ar
//        1000 ar ========> 1 ar ========> 1000ar * 1ar
////        Account account = this.accountExist(numeroCompte, connection);
//        this.setUpTransaction(connection);
        // Mila maka solde aloha
        double montant_ariary = montant * devise;
        double solde = this.getSold();
        System.out.println("Solde ====> " + solde + " ,,,, Devise ===> " + devise);
        if( solde < montant_ariary ) throw new Exception("Vous ne pouvez pas transferer ce montant : Solde insuffisant");
//        connection.close();
        return true;
    }
    
    public Account accountExist( Integer numeroCompte, Connection connection ) throws Exception{
        String sql = "select * from account where numero_compte = '" + numeroCompte +"'";
//        Connection connection = new Connect().getConnection();
System.out.println(sql);
        Account account = Dao.find(connection, sql, this);
        if( account == null ) throw new Exception("Le compte bancaire n'existe pas");
        account.setUpTransaction(connection);
//        connection.close();
        return account;
    }
    
    public Account accountExist(Integer numeroCompte) throws Exception{
        try( Connection connection = new Connect().getPostgres() ){
            return this.accountExist( numeroCompte, connection );
        }catch(Exception e){
            throw e;
        }
    }
    
    public void envoyer( Connection connection, double montant ) throws Exception{
        
        Transaction transaction = new Transaction();
        transaction.setDebit(0.0);
        transaction.setCredit(montant);
        transaction.setIdCompte(this.getIdAccount());
        transaction.setDatetime(new Timestamp(System.currentTimeMillis()));
        System.out.println("Envoye en cours");
        transaction.exec( connection );
    }
    
    public void recevoir( Connection connection, double montant ) throws Exception{
        Transaction transaction = new Transaction();
        transaction.setDebit(montant);
        transaction.setCredit(0.0);
        transaction.setIdCompte(this.getIdAccount());
//        transaction.setDate(null);
        transaction.setDatetime(new Timestamp(System.currentTimeMillis()));
        
        System.out.println("Reception en cours");
        transaction.exec( connection );
    }

/***/
}
