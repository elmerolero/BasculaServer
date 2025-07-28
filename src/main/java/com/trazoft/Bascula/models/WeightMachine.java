package com.trazoft.Bascula.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;

public class WeightMachine {
    private long id;
    private String name;
    private String description;
    private String port;
    private int baudRate;
    private int stopBits;
    private boolean isFlippedText;
    private String ipAddress;
    
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private boolean available;

    @ManyToOne(cascade = CascadeType.ALL)
    private Parity parityBit;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }

    public Parity getParityBit() {
        return parityBit;
    }

    public void setParityBit( Parity parityBit ){
        this.parityBit = parityBit;
    }
    
    public int getStopBits() {
        return stopBits;
    }

    public void setStopBits(int stopBits) {
        this.stopBits = stopBits;
    }

    public boolean isFlippedText() {
        return isFlippedText;
    }

    public void setFlippedText(boolean isFlippedText) {
        this.isFlippedText = isFlippedText;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    @Override
    public String toString(){
        return new StringBuilder("WeigthMachine{")
                    .append("id=").append(id).append(",")
                    .append("name=\"").append(name).append("\",")
                    .append("description=\"").append(description).append("\",")
                    .append("port=\"" ).append(port).append("\",")
                    .append("baudRate=").append(baudRate).append(",")
                    .append("parityBit=\"").append(parityBit.toString()).append("\",")
                    .append("stopBits=").append(stopBits).append(",")
                    .append("isFlippedText=").append(isFlippedText).append(",")
                    .append("ipAddress=\"").append(ipAddress).append("\",")
                    .append("creationDate=\"").append(creationDate != null ? creationDate.toString() : "").append("\",")
                    .append("lastUpdateDate=\"").append(lastUpdateDate != null ? lastUpdateDate.toString() : "").append("\",")
                    .append("available=").append(available).append("")
                    .append("}").toString();
    }
}
