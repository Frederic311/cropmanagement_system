package com.group2.cropmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(
        name = "crops",
        uniqueConstraints = @UniqueConstraint(columnNames = {"crop_name", "farm_id"})
)
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cropName;

    @Column
    private String cropDescription;

    @OneToMany(mappedBy = "crop")
    @JsonBackReference
    private List<Harvest> harvests;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonBackReference
    private Farm farm;
}
