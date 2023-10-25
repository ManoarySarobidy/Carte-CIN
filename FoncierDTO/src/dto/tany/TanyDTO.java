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
    
    public TanyDTO(boolean borne, double width, double height) {
        this.borne = borne;
        this.width = width;
        this.height = height;
        
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
