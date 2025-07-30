package com.trazoft.Bascula.models;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="weight_machine")
public class WeightMachine {
    @Id
    @SequenceGenerator(
        name="weight_machine_sequence",
        sequenceName = "weight_machine_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "weight_machine_sequence"
    )
    private long id;
    @Column(nullable = false, unique = true, length = 255)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String port;
    @Column(nullable = false)
    private int baudRate;
    @Column(nullable = false)
    private int stopBits;
    @Column(nullable = false)
    private boolean flippedText;
    @Column(nullable = false)
    private String ipAddress;
    
    @Column(nullable = false)
    private LocalDateTime creationDate;
    @Column(nullable = false)
    private LocalDateTime lastUpdateDate;
    @Column(nullable = false)
    private boolean available;

    @ManyToOne(cascade = CascadeType.ALL)
    private Parity parity;

    public WeightMachine() {}
    public WeightMachine(
        String name,
        String description,
        String port,
        int baudRate,
        int stopBits,
        Parity parity,
        boolean flippedText,
        String ipAddress,
        LocalDateTime creationDate,
        LocalDateTime lastUpdateDate,
        boolean available
    ){
        this.name = name;
        this.description = description;
        this.port = port;
        this.baudRate = baudRate;
        this.stopBits = stopBits;
        this.parity = parity;
        this.flippedText = flippedText;
        this.ipAddress = ipAddress;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.available = available;
    }

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

    public Parity getParity() {
        return parity;
    }

    public void setParity( Parity parity ){
        this.parity = parity;
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
    
    @Override
    public String toString(){
        return new StringBuilder("WeigthMachine{")
                    .append("id=").append(id).append(",")
                    .append("name=\"").append(name).append("\",")
                    .append("description=\"").append(description).append("\",")
                    .append("port=\"" ).append(port).append("\",")
                    .append("baudRate=").append(baudRate).append(",")
                    .append("parityBit=\"").append(parity.toString()).append("\",")
                    .append("stopBits=").append(stopBits).append(",")
                    .append("isFlippedText=").append(flippedText).append(",")
                    .append("ipAddress=\"").append(ipAddress).append("\",")
                    .append("creationDate=\"").append(creationDate != null ? creationDate.toString() : "").append("\",")
                    .append("lastUpdateDate=\"").append(lastUpdateDate != null ? lastUpdateDate.toString() : "").append("\",")
                    .append("available=").append(available).append("")
                    .append("}").toString();
    }
}
