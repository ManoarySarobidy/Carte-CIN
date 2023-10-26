/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tany.service;

import com.google.gson.Gson;
import com.module.banque.BanqueServiceRemote;
import com.module.tany.TanyLocal;
import dto.bank.AccountDTO;
import dto.devise.DeviseDTO;
import dto.tany.TanyDTO;
import java.util.Properties;
import java.util.Vector;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Cartel
 */

@Path("/tany")
public class TanyService {
//    @EJB
    TanyLocal tany;
    
    @GET
    @Path("/test/")
    public String test(){
        return "Test réussi";
    }
    
    @GET
    @Path("/devises")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDevises() throws Exception{
        Gson gson = new Gson();
        InitialContext x = new InitialContext();
        tany = (TanyLocal) x.lookup("java:global/Tany_EJB_EAR/Tany_Module_EJB/TanyEJB!com.module.tany.TanyLocal");
        System.out.println(tany);
        DeviseDTO[] devises = tany.getDevises();
        System.out.println("Hehe boy");
        return gson.toJson(devises);
    }
    
    @GET
    @Path("/getTany/{cin}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTany( @PathParam("cin") String cin ) throws Exception{
        Gson gson = new Gson();
        InitialContext x = new InitialContext();
        tany = (TanyLocal) x.lookup("java:global/Tany_EJB_EAR/Tany_Module_EJB/TanyEJB!com.module.tany.TanyLocal");
        Vector<TanyDTO> tanys =  this.tany.getTany(cin);
        return gson.toJson(tanys);
    }
    
    @GET
    @Path("/information/{cin}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll( @PathParam("cin") String cin ) throws Exception{
        InitialContext x = new InitialContext();
        tany = (TanyLocal) x.lookup("java:global/Tany_EJB_EAR/Tany_Module_EJB/TanyEJB!com.module.tany.TanyLocal");
        Properties props = new Properties();
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
        x = new InitialContext( props );
        BanqueServiceRemote banque = (BanqueServiceRemote) x.lookup("java:global/Banque_Server/Banque_Module/BanqueService!com.module.banque.BanqueServiceRemote");
        AccountDTO acc = banque.getBankAccount( cin );
        Vector<TanyDTO> tanys = tany.getTany( cin );
        
        // Inona ny tokony atao ato
        // Atao mamerina json mtahiry an'ireo attribut ireo
        
        return new Gson().toJson(acc);
    }
    
}
