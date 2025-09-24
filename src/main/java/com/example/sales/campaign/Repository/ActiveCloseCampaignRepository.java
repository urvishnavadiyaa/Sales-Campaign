package com.example.sales.campaign.Repository;

import com.example.sales.campaign.Model.ActiveCloseCampaign;
import com.example.sales.campaign.ScheduledTask.ActiveCampaign;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ActiveCloseCampaignRepository extends JpaRepository<ActiveCloseCampaign, Integer> {

    @Query(value = "SELECT * FROM active_campaign WHERE date(now()) > end_date", nativeQuery = true)
    List<ActiveCloseCampaign> getExpiredCampaign();

    @Modifying
    @Query(value = "DELETE FROM active_campaign WHERE CURDATE() > end_date", nativeQuery = true)
    void deleteExpiredCampaigns();

    @Query(value = "select * from active_campaign where p_id = ?1", nativeQuery = true)
    List<ActiveCloseCampaign> getProducts(int pId);

    @Query(value = "select sum(discount) from active_campaign where p_id = ?1 group by p_id", nativeQuery = true)
    int discount(int pId);
}
