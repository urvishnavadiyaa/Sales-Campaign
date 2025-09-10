package com.example.sales.campaign.Repository;

import com.example.sales.campaign.Model.ActiveCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveCampaignRepository extends JpaRepository<ActiveCampaign, Integer> {
}
