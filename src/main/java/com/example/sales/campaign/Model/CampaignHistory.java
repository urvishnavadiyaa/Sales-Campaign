package com.example.sales.campaign.Model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "campaign_history")
public class CampaignHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pid", nullable = false)
    private int pid;

    @Column(name = "cid", nullable = false)
    private int cid;

    @Column(name = "discount", nullable = false)
    private Double discount;

    @Column(name = "old_price", nullable = false)
    private Double oldPrice;

    public CampaignHistory() {}

    public CampaignHistory(int pid, Double discount, Double oldPrice) {
        this.pid = pid;
        this.discount = discount;
        this.oldPrice = oldPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }
}
