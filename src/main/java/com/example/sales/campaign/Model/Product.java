package com.example.sales.campaign.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int pId;

    @Column(name = "p_name", nullable = false)
    private String productName;

    @JsonProperty("mrp")
    @Column(name = "mrp", nullable = false)
    private double MRP;

    @Column(name = "curr_price", nullable = false)
    private double currentPrice;

    @Column(name = "discount", nullable = false)
    @Min(0)
    @Max(100)
    private Double discount;

    @Column(name = "inv_count", nullable = false)
    private int inventoryCount = 0;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCampaign> productCampaigns;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getMRP() {
        return MRP;
    }

    public void setMRP(double MRP) {
        this.MRP = MRP;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public Product(int pId, String productName, double MRP, double currentPrice, Double discount, int inventoryCount, List<ProductCampaign> productCampaigns) {
        this.pId = pId;
        this.productName = productName;
        this.MRP = MRP;
        this.currentPrice = currentPrice;
        this.discount = discount;
        this.inventoryCount = inventoryCount;
        this.productCampaigns = productCampaigns;
    }

    public Product() {
    }
}
