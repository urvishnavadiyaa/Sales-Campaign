package com.example.sales.campaign.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_campaign")
public class ProductCampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_id")
    private int pcId;

    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "c_id", nullable = false)
    private Campaign campaign;

    @Column(name = "discount", nullable = false)
    @Min(0)
    @Max(100)
    private Double discount;
}