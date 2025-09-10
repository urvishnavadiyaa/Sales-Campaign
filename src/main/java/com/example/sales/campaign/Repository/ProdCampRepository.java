package com.example.sales.campaign.Repository;

import com.example.sales.campaign.Model.Campaign;
import com.example.sales.campaign.Model.Product;
import com.example.sales.campaign.Model.ProductCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdCampRepository extends JpaRepository<ProductCampaign, Integer> {

    @Query(value = "select * from product_campaign where c_id = ?1", nativeQuery = true)
    List<ProductCampaign> findProductListByCampaign(int campaignId);


}
