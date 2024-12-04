package com.group2.cropmanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class CropDTO {
    private Long id;

    private String cropName;

    private String cropDescription;

    private Long farm_id;
}
