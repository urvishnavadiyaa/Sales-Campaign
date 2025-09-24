package com.example.sales.campaign.DTO.ResponseDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int pId;
    private String productName;
    private double mrp;
    @Min(0)
    @Max(100)
    private Double discount;
    private Double campaignDiscount;
    private Double totalDiscount;
    private double currentPrice;
    private int inventoryCount;

    public ProductDTO(int pId, String productName, double mrp, double currentPrice, Double discount, int inventoryCount) {
        this.pId = pId;
        this.productName = productName;
        this.mrp = mrp;
        this.currentPrice = currentPrice;
        this.discount = discount;
        this.inventoryCount = inventoryCount;
        this.campaignDiscount = 0.0;
        this.totalDiscount = discount;
    }
}
