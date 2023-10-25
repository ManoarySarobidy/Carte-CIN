/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity.devise;

import dto.devise.CourDTO;
import java.sql.Connection;
import java.sql.Date;
import java.util.Vector;
import mine.generic.Dao;
import mine.generic.annotation.Column;
import mine.generic.annotation.Table;
import sql.Connect;

/**
 *
 * @author Cartel
 */

@Table("cours_devise")
public class Cour{
    @Column("id_cours_devise")
    Integer id;
    
//    @Column("id_devise")
    String idDevise;
    
    @Column
    Double montant;
    @Column("date_cours")
    Date date;
    
    Devise devise;
    
    public void setId( Integer id ){
        this.id = id;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setIdDevise( String id ){
        this.idDevise = id;
    }
    public String getIdDevise(){
        return this.idDevise;
    }
    
    public void setMontant(Double montant){
        this.montant = montant;
    }
    public Double getMontant(){
        return this.montant;
    }
    
    public void setDate( Date date ){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }
    
    public void setDevise(Devise devise){
        this.devise = devise;
    }
    public Devise getDevise(){
        return this.devise;
    }
    
    public Cour[] getForDevise(Devise devise) throws Exception{
        String sql = "select * from cours_devise where id_devise = '" + devise.getId() + "'";
        Connection connection = new Connect().getConnection();
        Vector<Cour> cours = Dao.findAll(connection, this, sql);
        connection.close();
        return cours.toArray( new Cour[ cours.size() ] );
    }
    
    public Cour getCurrentCour() throws Exception{
        String sql = "select * from cours_devise where id_devise ='" + this.getDevise().getId() + "' order by date_cours desc";
        System.out.println("current cour == " + sql);
        Connection connection = new Connect().getPostgres();
        Cour cour = Dao.find(connection, sql, this);
        cour.setDevise(this.getDevise());
        connection.close();
        return cour;
    }
    
    public CourDTO asDTO(){
        CourDTO dto = new CourDTO( this.getId(), this.getDevise().getId(), this.getMontant(), this.getDate() );
        return dto;
    }
    
}
