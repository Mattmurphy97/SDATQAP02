package com.keyin.qap02;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tournament {

    // Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String loc;
    private String startDate;
    private String endDate;
    private int entryFee;
    private int prizeAmt;

    // 3 Constructors for Tournament object
    public Tournament(){

    }

    public Tournament(String loc, String startDate, String endDate, int entryFee, int prizeAmt){
        this.loc = loc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.entryFee = entryFee;
        this.prizeAmt = prizeAmt;
    }

    public Tournament(int id, String loc, String startDate, String endDate, int entryFee, int prizeAmt){
        this.id = id;
        this.loc = loc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.entryFee = entryFee;
        this.prizeAmt = prizeAmt;
    }

    // Getters/Setters & toString method
    public int getId() {
        return id;
    }

    public String getLoc() {
        return loc;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getEntryFee() {
        return entryFee;
    }

    public int getPrizeAmt() {
        return prizeAmt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    public void setPrizeAmt(int prizeAmt) {
        this.prizeAmt = prizeAmt;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", loc='" + loc + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", entryFee=" + entryFee +
                ", prizeAmt=" + prizeAmt +
                '}';
    }
}
