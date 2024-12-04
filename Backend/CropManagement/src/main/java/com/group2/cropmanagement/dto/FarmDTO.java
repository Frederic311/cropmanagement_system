package com.group2.cropmanagement.dto;

import lombok.Data;

@Data
public class FarmDTO {
    private Long id;
    private String name;
    private String description;
    private Long userId;
}
