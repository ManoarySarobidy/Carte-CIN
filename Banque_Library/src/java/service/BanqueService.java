/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.google.gson.Gson;
import com.module.banque.BanqueLocal;
import dto.bank.AccountDTO;
import dto.bank.TransferDTO;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Cartel
 */
@Path("/banks")
public class BanqueService {
    
    BanqueLocal bank;
    
    @GET
    @Path("/getBank/{cin}")
    @Produces("application/json")
    public String getBank( @PathParam("cin") String cin ) throws Exception {
        Gson gson = new Gson();
        InitialContext x = new InitialContext();
        bank = (BanqueLocal) x.lookup("java:global/Banque_Server/Banque_Module/BanqueService!com.module.banque.BanqueLocal");
        AccountDTO account = this.bank.getBankAccount(cin);
        System.out.println("eto isika izao");
        return gson.toJson(account);
    }
    
    @GET
    @Path("/transferer/{s}/{r}/{mo}/{devise}")
    public void ajouterTransfert( @PathParam("s") int s, @PathParam("r") int r, @PathParam("mo") double montant, @PathParam("devise") String devise ) throws Exception
    {
        // Inona ny ato
        TransferDTO transfer = new TransferDTO( s, r, montant, devise );
        InitialContext x = new InitialContext();
        bank = (BanqueLocal) x.lookup("java:global/Banque_Server/Banque_Module/BanqueService!com.module.banque.BanqueLocal");
        bank.transferer(transfer);
        System.out.println("1 : " + s + ", 2: " + r + ", 3: " + montant + ", 4: " + devise);
    }
    
}
