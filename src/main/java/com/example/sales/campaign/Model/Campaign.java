package com.example.sales.campaign.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int campaignId;

    @Column(name = "c_name", nullable = false)
    private String campaignName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<ProductCampaign> productCampaigns;

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
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

    public Campaign(int campaignId, String campaignName, LocalDate startDate, LocalDate endDate, List<ProductCampaign> productCampaigns) {
        this.campaignId = campaignId;
        this.campaignName = campaignName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productCampaigns = productCampaigns;
    }

    public Campaign() {
    }
}
