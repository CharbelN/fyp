package com.example.eventfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Address_Id;

    private String Address_Name;

    private int Latitude;

    private int Longitude;

    public Integer getAddress_Id() {
        return Address_Id;
    }

    public void setAddress_Id(Integer address_Id) {
        Address_Id = address_Id;
    }

    public String getAddress_Name() {
        return Address_Name;
    }

    public void setAddress_Name(String address_Name) {
        Address_Name = address_Name;
    }

    public int getLatitude() {
        return Latitude;
    }

    public void setLatitude(int latitude) {
        Latitude = latitude;
    }

    public int getLongitude() {
        return Longitude;
    }

    public void setLongitude(int longitude) {
        Longitude = longitude;
    }
}
