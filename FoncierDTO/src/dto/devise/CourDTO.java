/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.devise;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Cartel
 */
public class CourDTO implements Serializable{
    int id;
    String devise;
    double montant;
    Date date;
    
    public CourDTO( int id, String devise, double montant, Date date ){
        this.setDate(date);
        this.setId(id);
        this.setDevise(devise);
        this.setMontant(montant);
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public void setDevise(String devise){
        this.devise = devise;
    }
    public String getDevise(){
        return this.devise;
    }
    
    public void setMontant(double montant){
        this.montant = montant;
    }
    public double getMontant(){
        return this.montant;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }
}
