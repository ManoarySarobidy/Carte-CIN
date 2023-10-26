/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity.tany;

import java.sql.Connection;
import mine.generic.Dao;
import mine.generic.annotation.Column;
import mine.generic.annotation.Table;
import sql.Connect;

/**
 *
 * @author Cartel
 */
@Table("borne")
public class Coordinate {
    
    @Column(value="idBorne", isPrimary = true, isSerial = true)
    Integer id;
    @Column
    String longitude;
    @Column
    String latitude;
    @Column
    Integer idTany;
    transient Tany tany;
    
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    
    public void setLongitude(String longitude){
        this.longitude = longitude;
    }
    
    public String getLongitude(){
        return this.longitude;
    }
    
    public void setLatitude(String latitude){
        this.latitude = latitude;
    }
    public String getLatitude(){
        return this.latitude;
    }
    
    public void setTany(Tany tany){
        this.tany = tany;
    }
    public Tany getTany(){
        return this.tany;
    }
    
    public void setIdTany( Integer idTany ){
        this.idTany = idTany;
    }
    public Integer getIdTany(){
        return this.idTany;
    }
    
    public void saveBorne( dto.tany.Coordinate[] coords ) throws Exception{
        // Inona ny atao ato
        // Ande isauver any anaty base izao
        Connect connect = new Connect();
        Connection connection = connect.getPostgres();
        try{
            for( dto.tany.Coordinate c : coords ){
                Coordinate co = this.fromDTO(c);
                Dao.save(connection, co);
            }
            connection.commit();
        }catch(Exception e){
            connection.rollback();
            throw e;
        }finally{
            connection.close();
        }
    }
    
    Coordinate fromDTO( dto.tany.Coordinate c ){
        Coordinate co = new Coordinate();
        co.setIdTany(c.getIdTany());
        co.setLatitude(c.getLatitude());
        co.setLongitude(c.getLongitude());
        return co;
    }
    
    public dto.tany.Coordinate asDTO(){
        dto.tany.Coordinate coordinate = new dto.tany.Coordinate();
        coordinate.setId(this.getId());
        coordinate.setIdTany(this.getIdTany());
        coordinate.setLatitude(this.getLatitude());
        coordinate.setLongitude(this.getLongitude());
        return coordinate;
    }
    
    // Inona ny zavatra ilaina
    // Alaina ny coordonées ana tany iray
    // Izay ny asan'ito classe ito
    // Andao ary andramana eh
    // Any amin'ny affichage
    // 1 - Misy formulaire eo de ny atao amin'ilay formulaire de afaka mandefa données ( tableaux ) : longitude <=> latitude
    // 2 - Misy Carte eo de rehefa mikitika eo amin'ilay carte de enregistrer any anaty base ilay point clickena sady manao sary ihany
    // 3 - Mampiditra CIN de mamoaka ny information : Information générales, Santé, Tany, Banque
    // 4 - Vitaina ny aléa tamin'ny farany
    
}
