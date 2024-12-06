package com.group2.cropmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(
        name = "harvests",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "farm_id"})
)
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private LocalDate harvestDate;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "crop_id")
    @JsonManagedReference
    private Crop crop;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonBackReference
    private Farm farm;
}
