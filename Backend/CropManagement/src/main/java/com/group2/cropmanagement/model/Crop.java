package com.group2.cropmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @ManyToMany(mappedBy = "crops")
    @JsonBackReference
    private List<Harvest> harvests;

    @ManyToMany(mappedBy = "crops")
    @JsonBackReference
    private List<Farm> farms;
}
