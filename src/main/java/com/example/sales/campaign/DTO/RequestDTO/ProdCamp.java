package com.example.sales.campaign.DTO.RequestDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdCamp {
    private int id;

    @NotNull
    private int p_Id;

    @NotNull
    private int c_ID;

    @NotNull
    @Min(0)
    @Max(100)
    private Double discount;
}