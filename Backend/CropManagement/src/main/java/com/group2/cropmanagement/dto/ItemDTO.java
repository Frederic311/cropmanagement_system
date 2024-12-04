package com.group2.cropmanagement.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private Long farmId;
}
