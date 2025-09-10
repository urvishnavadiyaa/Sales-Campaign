package com.example.sales.campaign.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "product_campaign")
public class ProductCampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_id")
    private int pcId;

    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "c_id", nullable = false)
    private Campaign campaign;

    @Column(name = "discount", nullable = false)
    @Min(0)
    @Max(100)
    private Double discount;

    public int getPcId() {
        return pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public ProductCampaign() {
    }
}