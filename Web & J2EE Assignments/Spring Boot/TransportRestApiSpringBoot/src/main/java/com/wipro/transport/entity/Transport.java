package com.wipro.transport.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String source;
    private String destination;
    private double fare;

    
    public Transport() {
    }

   
    public Transport(String type, String source, String destination, double fare) {
        this.type = type;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

   
    public int getId() {  
        return id;
    }

    public void setId(int id) {  
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}



