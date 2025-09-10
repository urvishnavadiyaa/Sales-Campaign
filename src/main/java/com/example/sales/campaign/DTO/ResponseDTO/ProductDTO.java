package com.example.sales.campaign.DTO.ResponseDTO;

public class ProductDTO {
    private int p_Id;
    private double MRP;
    private int baseDiscount;
    private Double campaignDiscount;
    private Double totalDiscount;
    private double currPrice;
    private String pName;

    public ProductDTO() {
    }

    public ProductDTO(int p_Id, double MRP, int baseDiscount, Double campaignDiscount, Double totalDiscount, double currPrice, String pName) {
        this.p_Id = p_Id;
        this.MRP = MRP;
        this.baseDiscount = baseDiscount;
        this.campaignDiscount = campaignDiscount;
        this.totalDiscount = totalDiscount;
        this.currPrice = currPrice;
        this.pName = pName;
    }

    public int getP_Id() {
        return p_Id;
    }

    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }

    public double getMRP() {
        return MRP;
    }

    public void setMRP(double MRP) {
        this.MRP = MRP;
    }

    public int getBaseDiscount() {
        return baseDiscount;
    }

    public void setBaseDiscount(int baseDiscount) {
        this.baseDiscount = baseDiscount;
    }

    public Double getCampaignDiscount() {
        return campaignDiscount;
    }

    public void setCampaignDiscount(Double campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(double currPrice) {
        this.currPrice = currPrice;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
