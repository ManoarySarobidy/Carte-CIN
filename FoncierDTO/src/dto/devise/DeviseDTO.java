/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.devise;

import java.io.Serializable;

public class DeviseDTO implements Serializable{
    
    String code;
    String nom;
    
    CourDTO cour;
    
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return this.nom;
    }
    
    public void setCour( CourDTO cour ){
        this.cour = cour;
    }
    public CourDTO getCour(){
        return this.cour;
    }
    
    public DeviseDTO( String nom, String code ){
        this.setCode( code );
        this.setNom( nom );
    }
}
