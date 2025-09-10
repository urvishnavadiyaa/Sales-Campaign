package com.example.sales.campaign.Repository;

import com.example.sales.campaign.Model.CampaignHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignHistoryRepository extends JpaRepository<CampaignHistory, Integer> {
}
