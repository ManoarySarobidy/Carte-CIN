/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.module.tany;

import com.dto.PersonDTO;
import dto.bank.AccountDTO;
import dto.devise.DeviseDTO;
import dto.tany.TanyDTO;
import java.io.Serializable;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Cartel
 */
@Local
public interface TanyLocal extends Serializable {
    public Vector<TanyDTO> getTany(String cin) throws Exception;
    
    public DeviseDTO[] getDevises() throws Exception;
    
    public PersonDTO getPersonne(String cin) throws Exception;
    
    public AccountDTO getBank( String cin ) throws Exception;
    
}
