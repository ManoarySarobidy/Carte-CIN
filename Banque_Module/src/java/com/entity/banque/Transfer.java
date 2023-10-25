/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity.banque;

import com.module.tany.TanyEJBRemote;
import dto.bank.TransferDTO;
import dto.devise.DeviseDTO;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Properties;
import javax.naming.InitialContext;
import mine.generic.Dao;
import mine.generic.annotation.Column;
import mine.generic.annotation.Table;
import sql.Connect;

/**
 *
 * @author Cartel
 */
@Table("transfer")
public class Transfer {
    
    // Le numero de compte mpandefa
    // Le numero de compte mpandray
    // Ilay montant
    // ilay date de transfer
    @Column()
    Integer id;
    @Column
    Integer send;
    @Column
    Integer receive;
    @Column
    Double montant;
    
    String idDevise;
    
    @Column
    Timestamp date;
    
    Account sender;
    Account receiver;
    
    DeviseDTO devises;
    
    public Transfer( TransferDTO dto ) throws Exception{
        this.setSend(dto.getSend());
        this.setReceive(dto.getReceive());
        this.setMontant(dto.getMontant());
        this.setIdDevise(dto.getIdDevise());
        this.setDate(dto.getTime());
    }
    
    public void setDate( Timestamp date ){
        this.date = date;
    }
    public Timestamp getDate(){
        if( this.date == null ) this.setDate( new Timestamp(System.currentTimeMillis()) );
        return this.date;
    }
    
    public void setSend(Integer send) throws Exception{
        this.send = send;
        this.sender = new Account().accountExist(send);
    }
    public Integer getSend(){
        return this.send;
    }
    
    public void setReceive(Integer receive) throws Exception{
        this.receive = receive;
        this.receiver = new Account().accountExist( this.receive );
    }
    public Integer getReceive(){
        return this.receive;
    }
    
    public void setMontant( Double montant ) throws Exception{
        if( montant == null || montant < 0 ) throw new Exception("Vous ne pouvez pas transferer un montant négatif : " + montant);
        this.montant = montant;
    }
    
    public Double getMontant(){
        return this.montant;
    }
    
    public void executeTransfer() throws Exception{
        this.recupLastDevise();
        if( this.sender.canSend(this.getMontant(), this.getDevises().getCour().getMontant()) ){
            
            // Inona ny eto
            // sender -> credit
            // receiver <- debit
            // Insert into table transfer
            // Afaka asiana detail transfer
            System.out.println("tafiditra ato (3)");
            Connection connection = new Connect().getPostgres();
            try{
                double montant_ariary = this.getMontant()*this.getDevises().getCour().getMontant();
                this.sender.envoyer( connection, montant_ariary);
                this.receiver.recevoir(connection, montant_ariary);
                this.exec(connection);
                connection.commit();
            }catch(Exception e){
                connection.rollback();
                e.printStackTrace();
                throw e;
            }finally{
                try{
                    connection.close();
                }catch(Exception e){
                    throw e;
                }
            }
        }
    }
    
    public void exec( Connection connection ) throws Exception{
        try{
            String sql = "insert into transfert(id_send, id_receive, montant, cours_devise, date_transfert)values (" + this.getSend() + ", " + this.getReceive() + ", " + this.getMontant() + ", " + this.getDevises().getCour().getId() + ", '" + this.getDate() + "' )";
            Dao.save(connection, sql, this);
        }catch( Exception e ){
            throw e;
        }
    }
    
    public void setIdDevise(String idDevise) throws Exception{
        this.idDevise = idDevise;
    }
    
    public void setDevise() throws Exception{
        // Eto manantso EJB ana foncier ilalaovana anazy
        
    }
    
    public String getIdDevise(){
        return this.idDevise;
    }
    
      
    public void recupLastDevise() throws Exception{
        Properties props = new Properties();
        props.setProperty( "org.omg.CORBA.ORBInitialHost", "localhost" );
        props.setProperty( "org.omg.CORBA.ORBInitialPort", "3700" ); // Ovaina raha sendra tsy mety ito
        InitialContext context = new InitialContext(props);
        TanyEJBRemote tany = (TanyEJBRemote)context.lookup("java:global/Tany_EJB_EAR/Tany_Module_EJB/TanyEJB!com.module.tany.TanyEJBRemote");
        DeviseDTO devise = tany.getDevise( this.getIdDevise() );
        this.setDevises(devise);
    }
    
    public void setDevises(DeviseDTO dto){
        this.devises = dto;
    }
    public DeviseDTO getDevises(){
        return this.devises;
    }
    
    
}
