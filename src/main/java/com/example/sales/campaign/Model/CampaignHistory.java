package com.example.sales.campaign.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaign_history")
public class CampaignHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pid", nullable = false)
    private int pid;

    @Column(name = "cid", nullable = false)
    private int cid;

    @Column(name = "discount", nullable = false)
    private Double discount;

    @Column(name = "old_price", nullable = false)
    private Double oldPrice;

}
