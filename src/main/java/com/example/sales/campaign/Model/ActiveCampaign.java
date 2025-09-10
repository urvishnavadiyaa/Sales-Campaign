package com.example.sales.campaign.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "active_campaign")
public class ActiveCampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "p_id", nullable = false)
    private int pId;

    @Column(name = "c_id", nullable = false)
    private int cId;

    @Column(nullable = false)
    private Double discount;

    @Column(nullable = false)
    private double price;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    public ActiveCampaign() {}

    public ActiveCampaign(int pId, int cId, Double discount, Double price, LocalDate startDate, LocalDate endDate) {
        this.pId = pId;
        this.cId = cId;
        this.discount = discount;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

