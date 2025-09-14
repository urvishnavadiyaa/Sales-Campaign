package com.example.sales.campaign.Controller;

import com.example.sales.campaign.DTO.RequestDTO.ProdCamp;
import com.example.sales.campaign.Model.ActiveCloseCampaign;
import com.example.sales.campaign.Model.Campaign;
import com.example.sales.campaign.Model.Product;
import com.example.sales.campaign.Model.ProductCampaign;
import com.example.sales.campaign.ScheduledTask.ActiveCampaign;
import com.example.sales.campaign.ScheduledTask.CloseCampaign;
import com.example.sales.campaign.Service.Salesservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class salesController {

    @Autowired
    Salesservice salesservice;

    @Autowired
    ActiveCampaign activeCampaign;

    @Autowired
    CloseCampaign closeCampaign;


    @PostMapping("/save-product")
    public ResponseEntity<?> saveProducts(@RequestBody List<Product> products) {
        try {
            List<Product> saved = salesservice.saveAll(products);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @PostMapping("/save-campaign")
    public ResponseEntity<?> saveCampaign(@RequestBody List<Campaign> campaigns) {
        try {
            List<Campaign> saved = salesservice.saveAllCampaign(campaigns);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @PostMapping("/save-product_campaign1")
    public ResponseEntity<?> saveProCam(@Valid @RequestBody List<ProdCamp> prodCampDTOs) {
        try {
            List<ProductCampaign> savedList = salesservice.addProdCamp1(prodCampDTOs);
            return ResponseEntity.ok(savedList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @PostMapping("/save-product_campaign2")
    public ResponseEntity<?> saveProCam2(@RequestBody ProdCamp prodCampDTO) {
        try {
            ProductCampaign prodCampDTO1 = salesservice.addProdCamp2(prodCampDTO);
            return ResponseEntity.ok(prodCampDTO1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

//    @GetMapping("/save-product_campaign3")
//    public ResponseEntity<?> saveProCam3() {
//        try {
//            List<ActiveCloseCampaign> campaigns = closeCampaign.InactiveCampaign();
//            return ResponseEntity.ok(campaigns);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error saving data: " + e.getMessage());
//        }
//    }

}
