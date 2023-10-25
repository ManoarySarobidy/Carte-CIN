/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.module.tany;

import com.dto.PersonDTO;
import com.entity.devise.Devise;
import com.entity.tany.Tany;
import com.google.gson.Gson;
import com.module.banque.BanqueServiceRemote;
import dto.bank.AccountDTO;
import dto.devise.DeviseDTO;
import dto.tany.TanyDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ejb.Stateless;
import sql.*;
import java.sql.Connection;
import java.util.Properties;
import java.util.Vector;
import javax.naming.InitialContext;
import mine.generic.Dao;

/**
 *
 * @author Cartel
 */

@Stateless
public class TanyEJB implements TanyEJBRemote, TanyLocal {

    /**
     *
     * @param cin
     * @return
     */
    @Override
    public Vector<TanyDTO> getTany(String cin) {
        System.out.println( "Tany recuperer" );
        try{
            Vector<Tany> tanys = this.getTanys(cin);
            return this.toDto(tanys);
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Vector<Tany> getTanys( String cin ) throws Exception{
        String sql = "select * from tany where cin = '" + cin + "'";
        try{
            Connect c = new Connect();
            Connection re = c.getPostgres();
            Vector<Tany> tany = Dao.findAll(re, new Tany(), sql);
            re.close();
            if( tany.isEmpty() ) throw new NullPointerException( "Tsy manana tany io olona io" );
            return tany;
        }catch(Exception e){
            throw e;
        }
    }
    
    private Vector<TanyDTO> toDto( Vector<Tany> tanys ){
        Vector<TanyDTO> tanyDto = new Vector<TanyDTO>();
        for( Tany tany : tanys ){
            TanyDTO dto = new TanyDTO( tany.isBorne(), tany.getWidth(), tany.getLength());
            tanyDto.add(dto);
        }
        return tanyDto;
    }
    
    public DeviseDTO[] getDevises() throws Exception{
        System.out.println("Ato devise");
        DeviseDTO[] devises = new Devise().getDevises();
        return devises;
    }
    
    public DeviseDTO getDevise(String idDevise) throws Exception{
        Devise devise = new Devise().getDevise(idDevise);
        return devise.toDto(devise);
    }
    
    // 1 - Maka personne C#
    
    @Override
    public PersonDTO getPersonne( String cin ) throws Exception{
        String api_endpoint = "http://localhost:5227/Personne/GetPersonne?cin=" + cin;
        URL urls = new URL(api_endpoint);
        HttpURLConnection connection = (HttpURLConnection)urls.openConnection();
        connection.setRequestMethod("GET");
        
        int reponse_code = connection.getResponseCode();
        if( reponse_code == HttpURLConnection.HTTP_OK ){
            BufferedReader reader = new BufferedReader( new InputStreamReader(connection.getInputStream()) );
            String inputLine;
            StringBuilder reponse = new StringBuilder();
            while( (inputLine = reader.readLine()) != null ){ reponse.append(inputLine); }
            reader.close();
            String rp = reponse.toString();
            Gson gson = new Gson();
            PersonDTO person = gson.fromJson(rp, PersonDTO.class);
            System.out.println("response ::::=> " + reponse.toString());
            return person;
        }else{
            System.out.println("Erreur be lele");
            throw new Exception("Big exception very big");
        }
    }
    
    // Alaina ny information bancaire
    // Atao EJB
    
    public AccountDTO getBank( String cin ) throws Exception{
        Properties props = new Properties();
        props.setProperty( "org.omg.CORBA.ORBInitialHost", "localhost" );
        props.setProperty( "org.omg.CORBA.ORBInitialPort", "1234" ); // Ovaina raha sendra tsy mety ito
        InitialContext context = new InitialContext(props);
        BanqueServiceRemote banque = (BanqueServiceRemote)context.lookup("java:global/Banque_Server/Banque_Module/BanqueService!com.module.banque.BanqueServiceRemote");
        AccountDTO dto = banque.getBankAccount(cin);
        context.close();
        return dto;
//        DeviseDTO devise = tany.getDevise( this.getIdDevise() );
//        this.setDevises(devise);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
