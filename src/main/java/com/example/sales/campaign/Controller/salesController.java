package com.example.sales.campaign.Controller;

import com.example.sales.campaign.DTO.RequestDTO.ProdCamp;
import com.example.sales.campaign.DTO.ResponseDTO.ProductDTO;
import com.example.sales.campaign.Model.ActiveCloseCampaign;
import com.example.sales.campaign.Model.Campaign;
import com.example.sales.campaign.Model.Product;
import com.example.sales.campaign.Model.ProductCampaign;
import com.example.sales.campaign.ScheduledTask.ActiveCampaign;
import com.example.sales.campaign.ScheduledTask.CloseCampaign;
import com.example.sales.campaign.Service.Salesservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/save-product_campaign")
    public ResponseEntity<?> saveProCam(@Valid @RequestBody List<ProdCamp> prodCampDTOs) {
        try {
            List<ProductCampaign> savedList = salesservice.addProdCamp1(prodCampDTOs);
            return ResponseEntity.ok(savedList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @PostMapping("/save-product_campaigns")
    public ResponseEntity<?> saveProCam2(@RequestBody ProdCamp prodCampDTO) {
        try {
            ProductCampaign prodCampDTO1 = salesservice.addProdCamp2(prodCampDTO);
            return ResponseEntity.ok(prodCampDTO1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @GetMapping("/products")
    public Map<String, Object> getProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Page<Product> productPage = salesservice.getProductsPage(page, pageSize);
        List<ProductDTO> productDTOs = salesservice.convertToDTO(productPage.getContent());

        Map<String, Object> response = new HashMap<>();
        response.put("products", productDTOs);
        response.put("page", page);
        response.put("pageSize", pageSize);
        response.put("totalPages", productPage.getTotalPages());

        return response;
    }
}
