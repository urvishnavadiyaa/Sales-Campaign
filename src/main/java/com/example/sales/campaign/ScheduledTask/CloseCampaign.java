package com.example.sales.campaign.ScheduledTask;

import com.example.sales.campaign.Model.ActiveCloseCampaign;
import com.example.sales.campaign.Model.Product;
import com.example.sales.campaign.Model.ProductCampaign;
import com.example.sales.campaign.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ActiveCloseCampaign> InactiveCampaign() {
        List<ActiveCloseCampaign> campaigns = activeCloseCampaignRepository.getExpiredCampaign();

        for (ActiveCloseCampaign ac : campaigns) {
            Product product = productRepository.findById(ac.getPId());
            double price = ac.getPrice() / (1 - ac.getDiscount() / 100);
            product.setCurrentPrice(price);
            productRepository.save(product);
        }
        activeCloseCampaignRepository.deleteExpiredCampaigns();
        return campaigns;
    }
}
