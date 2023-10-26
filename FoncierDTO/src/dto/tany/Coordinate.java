/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.tany;

import java.io.Serializable;

/**
 *
 * @author Cartel
 */

public class Coordinate implements Serializable{
    
    Integer id;
    Integer idTany;
    String longitude;
    String latitude;
    
    public Coordinate( String lon, String lat ){
        this.setLatitude(lat);
        this.setLongitude(lon);
    }
    
    public Coordinate(Integer idTany, String lon, String lat){
        this.setLatitude(lat);
        this.setLongitude(lon);
        this.setIdTany(idTany);
    }

    public Coordinate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTany() {
        return idTany;
    }

    public void setIdTany(Integer idTany) {
        this.idTany = idTany;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
}
