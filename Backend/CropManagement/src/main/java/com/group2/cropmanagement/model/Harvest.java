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
@Table(name = "harvest")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate harvestDate;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "harvest_crops",
            joinColumns = @JoinColumn(name = "harvest_id"),
            inverseJoinColumns = @JoinColumn(name = "crop_id")
    )
    @JsonManagedReference
    private List<Crop> crops;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonBackReference
    private Farm farm;
}
