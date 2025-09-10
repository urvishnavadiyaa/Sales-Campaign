package com.example.sales.campaign.Repository;

import com.example.sales.campaign.Model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    @Query(value = "select * from campaign where date(now()) between start_date and end_date",nativeQuery = true)
    List<Campaign> getActiveCampaign();
}
