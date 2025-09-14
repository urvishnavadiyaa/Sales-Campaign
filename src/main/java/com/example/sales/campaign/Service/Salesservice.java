package com.example.sales.campaign.Service;


import com.example.sales.campaign.DTO.RequestDTO.ProdCamp;
import com.example.sales.campaign.Model.*;
import com.example.sales.campaign.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Salesservice {

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

    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Campaign> saveAllCampaign(List<Campaign> campaigns) {
        return campaignRepository.saveAll(campaigns);
    }

    public List<ProductCampaign> addProdCamp1(List<ProdCamp> dtos) {
        List<ProductCampaign> savedList = new ArrayList<>();

        for (ProdCamp dto : dtos) {
            ProductCampaign pc = new ProductCampaign();
            pc.setDiscount(dto.getDiscount());

            Product product = productRepository.findById(dto.getP_Id())
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

        Product product = productRepository.findById(prodCampDTO.getP_Id())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Campaign campaign = campaignRepository.findById(prodCampDTO.getC_ID())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        ProductCampaign pc = new ProductCampaign();
        pc.setProduct(product);
        pc.setCampaign(campaign);
        pc.setDiscount(prodCampDTO.getDiscount());

        return prodCampRepository.save(pc);
    }

}
