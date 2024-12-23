package com.group2.cropmanagement.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class HarvestDTO {
    private Long id;

    private String title;

    private LocalDate harvestDate;

    private Integer quantity;

    private Long farmId;

    private Long cropId;

}
