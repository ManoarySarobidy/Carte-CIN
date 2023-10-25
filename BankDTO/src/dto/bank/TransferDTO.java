/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.bank;

import java.sql.Timestamp;

/**
 *
 * @author Cartel
 */
public class TransferDTO {
    
    Integer send;
    Integer receive;
    double montant;
    Timestamp time;
    String idDevise;
    
    public TransferDTO(Integer send, Integer receive, double montant, Timestamp time, String idDevise){
        this.setIdDevise(idDevise);
        this.setMontant(montant);
        this.setReceive(receive);
        this.setSend(send);
        this.setTime(time);
    }
    
    public TransferDTO(Integer send, Integer receive, double montant, String idDevise){
        this.setIdDevise(idDevise);
        this.setMontant(montant);
        this.setReceive(receive);
        this.setSend(send);
    }
    
    public TransferDTO(){
    }

    public Integer getSend() {
        return send;
    }

    public void setSend(Integer send) {
        this.send = send;
    }

    public Integer getReceive() {
        return receive;
    }

    public void setReceive(Integer receive) {
        this.receive = receive;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(String idDevise) {
        this.idDevise = idDevise;
    }
    
}
