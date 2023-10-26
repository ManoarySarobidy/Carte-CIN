/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.tany;

import java.io.Serializable;

public class TanyDTO implements Serializable{
    
    boolean borne;
    double width;
    double height;
    String addresse;
    String cin;
    Coordinate[] coordinates;
    
    public TanyDTO(boolean borne, double width, double height) {
        this.borne = borne;
        this.width = width;
        this.height = height;
        
    }
    
    public void setCoordinates(Coordinate[] coords){
        this.coordinates = coords;
    }
    public Coordinate[] getCoordinates(){
        return this.coordinates;
    }
    
    public TanyDTO(){}
    
    public void setAddresse(String addresse){
        this.addresse = addresse;
    }
    public String getAddresse(){
        return this.addresse;
    }
    
    public void setCin(String c){
        this.cin = c;
    }
    public String getCin(){
        return this.cin;
    }
    
    
    
    public boolean isBorne() {
        return borne;
    }

    public void setBorne(boolean borne) {
        this.borne = borne;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public double getSurfaceM2(){
        return this.getWidth() * this.getHeight();
    }
    
    public double getSurfaceHa(){
        // 1 ha --> 10 000 m2
        // ? ha --> mySurface 
        double conversion = 10000;
        return this.getSurfaceM2() / conversion;
    }    
    
}
