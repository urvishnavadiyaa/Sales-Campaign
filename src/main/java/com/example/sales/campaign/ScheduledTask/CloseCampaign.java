package com.example.sales.campaign.ScheduledTask;

import com.example.sales.campaign.Model.ActiveCloseCampaign;
import com.example.sales.campaign.Model.Product;
import com.example.sales.campaign.Model.ProductCampaign;
import com.example.sales.campaign.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloseCampaign {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProdCampRepository prodCampRepository;

    @Autowired
    CampaignHistoryRepository campaignHistoryRepository;

    @Autowired
    ActiveCloseCampaignRepository activeCloseCampaignRepository;

    @Scheduled(cron = "0 18 15 * * *")
    public void InactiveCampaign() {
        System.out.println("started");
        List<ActiveCloseCampaign> campaigns = activeCloseCampaignRepository.getExpiredCampaign();

        if (!campaigns.isEmpty()) {
            for (ActiveCloseCampaign ac : campaigns) {
                Product product = productRepository.findByPId(ac.getPId());
                double price = ac.getPrice() / (1 - ac.getDiscount() / 100);
                product.setCurrentPrice(price);
                productRepository.save(product);
            }
            activeCloseCampaignRepository.deleteExpiredCampaigns();
        }
    }
}
