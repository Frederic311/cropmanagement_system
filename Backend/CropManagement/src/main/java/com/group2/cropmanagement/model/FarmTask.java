package com.group2.cropmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tasks")
public class FarmTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date deadline;

    @Column
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonBackReference
    private Farm farm;
}
