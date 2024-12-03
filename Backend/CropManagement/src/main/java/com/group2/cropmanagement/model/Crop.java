package com.group2.cropmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "crops")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cropName;

    @Column
    private String cropDescription;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonBackReference
    private Farm farm;
}
