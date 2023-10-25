/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto;

import com.dto.sante.Sante;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Cartel
 */
public class PersonDTO implements Serializable{
    // Manana Sante ny olona iray
    Integer idPersonne;
    String cin;
    String firstName;
    String lastName;
    String dateNaissance;
    String groupeSanguin;
    Sante sante;

    public Sante getSante() {
        return sante;
    }

    public void setSante(Sante sante) {
        this.sante = sante;
    }
    
    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }
    
}
