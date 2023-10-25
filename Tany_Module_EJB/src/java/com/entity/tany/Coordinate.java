/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity.tany;

import mine.generic.annotation.Column;
import mine.generic.annotation.Table;

/**
 *
 * @author Cartel
 */
@Table("coordinate")
public class Coordinate {
    
    @Column(value="id", isPrimary = true, isSerial = true)
    Integer id;
    @Column
    Double longitude;
    @Column
    Double latitude;
    @Column
    Integer idTany;
    Tany tany;
    
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    
    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }
    
    public Double getLongitude(){
        return this.longitude;
    }
    
    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }
    public Double getLatitude(){
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
