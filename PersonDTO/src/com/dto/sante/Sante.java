/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto.sante;

import java.io.Serializable;

/**
 *
 * @author Cartel
 */
public class Sante implements Serializable{
    Allergie[] allergie;

    public Allergie[] getAllergie() {
        return allergie;
    }

    public void setAllergie(Allergie[] allergie) {
        this.allergie = allergie;
    }
    
}
