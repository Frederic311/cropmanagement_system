package com.group2.cropmanagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FarmTaskDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate deadline;
    private Boolean isCompleted;
    private Long farmId;
}
