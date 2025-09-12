package com.example.sales.campaign.ScheduledTask;

import com.example.sales.campaign.Model.*;
import com.example.sales.campaign.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ActiveCampaign {

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


    //    @Scheduled(cron = "0 45 16 * * *")
    public List<ProductCampaign> ActivateCampaign() {
        List<Campaign> campaigns = campaignRepository.getActiveCampaign();

        List<ProductCampaign> productslist = new ArrayList<>();

        for (Campaign c : campaigns) {
            List<ProductCampaign> products = prodCampRepository.findProductListByCampaign(c.getCampaignId());
            productslist.addAll(products);
        }

        for (ProductCampaign pc : productslist) {
            CampaignHistory ch = new CampaignHistory();
            ch.setPid(pc.getProduct().getpId());
            ch.setCid(pc.getCampaign().getCampaignId());
            ch.setDiscount(pc.getDiscount());
            ch.setOldPrice(pc.getProduct().getCurrentPrice());
            campaignHistoryRepository.save(ch);

            Product p = pc.getProduct();
            double price = (p.getCurrentPrice() * pc.getDiscount()) / 100;
            double finalPrice = p.getCurrentPrice() - price;
            p.setCurrentPrice(finalPrice);
            productRepository.save(p);

            ActiveCloseCampaign ac = new ActiveCloseCampaign();
            ac.setPId(pc.getProduct().getpId());
            ac.setCId(pc.getCampaign().getCampaignId());
            ac.setDiscount(pc.getDiscount());
            ac.setStartDate(pc.getCampaign().getStartDate());
            ac.setEndDate(pc.getCampaign().getEndDate());
            ac.setPrice(finalPrice);
            activeCloseCampaignRepository.save(ac);
        }
        return productslist;
    }
}
