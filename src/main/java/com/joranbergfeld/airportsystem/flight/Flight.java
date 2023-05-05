package com.joranbergfeld.airportsystem.flight;


import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gateId;
    private Long planeId;
    private Long airlinerId;

    private long planeAtGateTime;
    private long boardingTime;
    private long taxiTime;
    private boolean active = true;
    //TODO add date to this object

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public Long getAirlinerId() {
        return airlinerId;
    }

    public void setAirlinerId(Long airlinerId) {
        this.airlinerId = airlinerId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(long boardingTime) {
        this.boardingTime = boardingTime;
    }

    public long getTaxiTime() {
        return taxiTime;
    }

    public void setTaxiTime(long taxiTime) {
        this.taxiTime = taxiTime;
    }

    public long getPlaneAtGateTime() {
        return planeAtGateTime;
    }

    public void setPlaneAtGateTime(long planeAtGateTime) {
        this.planeAtGateTime = planeAtGateTime;
    }
}
