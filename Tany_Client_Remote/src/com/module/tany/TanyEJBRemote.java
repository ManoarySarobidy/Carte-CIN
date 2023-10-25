/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.module.tany;

import dto.devise.DeviseDTO;
import dto.tany.TanyDTO;
import java.io.Serializable;
import java.util.Vector;
import javax.ejb.Remote;

/**
 *
 * @author Cartel
 */
@Remote
public interface TanyEJBRemote extends Serializable {
    /// Inona ny tokony ho ato
    // Tokony hoe afaka maka ny tany ho an'olona
    
    public Vector<TanyDTO> getTany( String cin );
    
    public DeviseDTO[] getDevises() throws Exception;
    
    public DeviseDTO getDevise(String id) throws Exception;
}
