package com.example.sales.campaign.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
