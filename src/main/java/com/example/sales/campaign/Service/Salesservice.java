package com.example.sales.campaign.Service;


import com.example.sales.campaign.DTO.RequestDTO.ProdCamp;
import com.example.sales.campaign.Model.*;
import com.example.sales.campaign.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Salesservice {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProdCampRepository prodCampRepository;

    @Autowired
    CampaignHistoryRepository campaignHistoryRepository;

    @Autowired
    ActiveCampaignRepository activeCampaignRepository;

    public List<Product> saveAll(List<Product> products) {
        return salesRepository.saveAll(products);
    }

    public List<Campaign> saveAllCampaign(List<Campaign> campaigns) {
        return campaignRepository.saveAll(campaigns);
    }

    public List<ProductCampaign> addProdCamp1(List<ProdCamp> dtos) {
        List<ProductCampaign> savedList = new ArrayList<>();

        for (ProdCamp dto : dtos) {
            ProductCampaign pc = new ProductCampaign();
            pc.setDiscount(dto.getDiscount());

            Product product = salesRepository.findById(dto.getP_Id())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID: " + dto.getP_Id()));
            pc.setProduct(product);

            Campaign campaign = campaignRepository.findById(dto.getC_ID())
                    .orElseThrow(() -> new RuntimeException("Campaign not found with ID: " + dto.getC_ID()));
            pc.setCampaign(campaign);

            savedList.add(prodCampRepository.save(pc));
        }

        return savedList;
    }


    public ProductCampaign addProdCamp2(ProdCamp prodCampDTO) {

        Product product = salesRepository.findById(prodCampDTO.getP_Id())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Campaign campaign = campaignRepository.findById(prodCampDTO.getC_ID())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        ProductCampaign pc = new ProductCampaign();
        pc.setProduct(product);
        pc.setCampaign(campaign);
        pc.setDiscount(prodCampDTO.getDiscount());

        return prodCampRepository.save(pc);
    }

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
            salesRepository.save(p);

            ActiveCampaign ac = new ActiveCampaign();
            ac.setPId(pc.getProduct().getpId());
            ac.setCId(pc.getCampaign().getCampaignId());
            ac.setDiscount(pc.getDiscount());
            ac.setStartDate(pc.getCampaign().getStartDate());
            ac.setEndDate(pc.getCampaign().getEndDate());
            ac.setPrice(finalPrice);
            activeCampaignRepository.save(ac);
        }
        return productslist;
    }

    

}
