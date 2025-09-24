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
@Table(name = "active_campaign")
public class ActiveCloseCampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "p_id", nullable = false)
    private int pId;

    @Column(name = "c_id", nullable = false)
    private int cId;

    @Column(nullable = false)
    private Double discount;

    @Column(nullable = false)
    private double price;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

}

