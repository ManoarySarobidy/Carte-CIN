/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity.tany;
import dto.tany.TanyDTO;
import java.sql.Connection;
import java.util.Vector;
import mine.generic.Dao;
import mine.generic.annotation.*;
import sql.Connect;
/**
 *
 * @author Cartel
 */

// Recuperer avy anaty database

@Table("Tany")
public class Tany {
    
    @Column(isPrimary = true, isSerial = true)
    Integer id;
    @Column
    String cin;
    @Column
    Boolean borne;
    @Column(value = "largeur")
    Double width;
    @Column("longueur")
    Double length;
    @Column
    String addresse;
    
    public void setAddresse(String ad){
        this.addresse = ad;
    }
    public String getAddresse(){
        return this.addresse;
    }
    
    // Ny tany dia manana coordonnées bobaka be
    // Ny coordonées de ensemble ana lognitude sy latitude
    
    Coordinate[] coordinates;
    
    public void setId(Integer id){
        this.id = id;
    }
    public void setBorne( Boolean borne ){
        this.borne = borne;
    }
    public void setWidth( Double value ){
        this.width = value;
    }
    public void setLength( Double value ){
        this.length = value;
    }
    
    public void setCin(String value){
        this.cin = value;
    }
    public String getCin(){
        return this.cin;
    }
    
    public Integer getId(){
        return this.id;
    }
    public Boolean isBorne(){
        return this.borne;
    }
    public Double getWidth(){
        return this.width;
    }
    public Double getLength(){
        return this.length;
    }
    
    public double getSurfaceM2(){
        return this.getWidth() * this.getLength();
    }
    
    public double getSurfaceHa(){
        // 1 ha --> 10 000 m2
        // ? ha --> mySurface 
        double conversion = 10000;
        return this.getSurfaceM2() / conversion;
    }    
    
    public void setCoordinates( Coordinate[] coordinates ){
        this.coordinates = coordinates;
    }
    
    public void setCoordinates() throws Exception{
        String sql = "select * from coordinate where idTany = " + this.getId();
        Connection connection = new Connect().getPostgres();
        Vector<Coordinate> coords = Dao.findAll(connection, this, sql);
        connection.close();
        Coordinate[] coordinates = coords.toArray( new Coordinate[ coords.size() ] );
        this.setCoordinates(coordinates);
    }
    
    public dto.tany.Coordinate[] getCoordinateAsDTO(){
        dto.tany.Coordinate[] cs = new dto.tany.Coordinate[ this.getCoordinates().length ];
        for( int i = 0;i < cs.length ; i++ ){
            dto.tany.Coordinate c = this.getCoordinates()[i].asDTO();
        }
        return cs;
    }
    
    public Coordinate[] getCoordinates(){
        return this.coordinates;
    }
    
    public void save( TanyDTO tanys ) throws Exception{
        this.setAddresse(tanys.getAddresse());
        this.setCin(tanys.getCin());
        this.setBorne(tanys.isBorne());
        Connection connection = new Connect().getPostgres();
        try{
            Dao.save(connection, this);
            connection.close();
        }catch(Exception e){
            connection.rollback();
            throw e;
        }finally{
            connection.close();
        }
    }
    
    
    
    // Inona ny tokony atao zao
    // Manao an'ilay affichage amin'ny c#
    // Atao mandeha ilay mametraka coordonées
    // Atao ilay input
    // Andao andramana arany
    // Andao aloha andramana izany input izany
    
    
}
