package com.example.sales.campaign.DTO.RequestDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProdCamp {
    private int id;

    @NotNull
    private int p_Id;

    @NotNull
    private int c_ID;

    @NotNull
    @Min(0)
    @Max(100)
    private Double discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getP_Id() {
        return p_Id;
    }

    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }

    public int getC_ID() {
        return c_ID;
    }

    public void setC_ID(int c_ID) {
        this.c_ID = c_ID;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}