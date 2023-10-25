/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity.devise;

import dto.devise.DeviseDTO;
import java.sql.Connection;
import java.util.Vector;
import mine.generic.Dao;
import mine.generic.annotation.Column;
import mine.generic.annotation.Table;
import sql.Connect;

/**
 *
 * @author Cartel
 */
@Table("devise")
public class Devise {
    
    @Column(isPrimary = true)
    String id;
    @Column
    String name;
    
    Cour[] cours;
    Cour currentCour;
    
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    
    public void setCurrentCour() throws Exception{
        this.setCurrentCour( new Cour() );
        this.getCour().setDevise(this);
        this.setCurrentCour( this.getCour().getCurrentCour() );
    }   
    
    public void setCurrentCour(Cour cour){
        this.currentCour = cour;
    }
    public Cour getCour(){
        return this.currentCour;
    }
    
    public void setCours() throws Exception{
        Cour[] courss = new Cour().getForDevise( this );
        this.setCours(courss);
    }
    
    public void setCours( Cour[] cours ){
        this.cours = cours;
    }
    public Cour[] getCours(){
        return this.cours;
    }
    
    
    public Devise getDevise( String id ) throws Exception{
        Devise devise = new Devise();
        devise.setId( id );
        Connection connection = new Connect().getPostgres();
        devise = Dao.find(connection, devise);
        devise.setCurrentCour();
        return devise;
    }
    
    public DeviseDTO[] getDevises() throws Exception{
        Connection connection = new Connect().getPostgres();
        Vector<Devise> devises = Dao.findAll(connection, this);
        connection.close();
        return this.toDto( devises );
    }
    
    public DeviseDTO[] toDto( Vector<Devise> devises ){
        Vector<DeviseDTO> dtos = new Vector<DeviseDTO>();
        for( Devise devise : devises ){
           DeviseDTO dto = new DeviseDTO( devise.getName(), devise.getId() );
           dtos.add(dto);
        }
        return dtos.toArray( new DeviseDTO[ dtos.size() ] );
    }
    
    public DeviseDTO toDto( Devise devise ){
        DeviseDTO dto = new DeviseDTO( devise.getName(), devise.getId() );
        dto.setCour( devise.getCour().asDTO() );
        return dto;
    }
    
}
