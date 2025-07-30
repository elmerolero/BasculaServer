package com.trazoft.Bascula.dto;

public class WeigthMachineDTO {
    private long id;
    private String name;
    private String description;
    private String port;
    private int baudRate;
    private int stopBits;
    private Long parityId;
    private boolean flippedText;
    private String ipAddress;
    
    private boolean available;

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

    public Long getParityId() {
        return parityId;
    }

    public void setParityId( Long parityId ){
        this.parityId = parityId;
    }
    
    public int getStopBits() {
        return stopBits;
    }

    public void setStopBits(int stopBits) {
        this.stopBits = stopBits;
    }

    public boolean isFlippedText() {
        return flippedText;
    }

    public void setFlippedText(boolean flippedText) {
        this.flippedText = flippedText;
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
}
