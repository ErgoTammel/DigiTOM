package com.example.digitom.domain.safetyfield;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "safety_field", schema = "digi_tom")
public class SafetyField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "field_number", nullable = false)
    private Integer fieldNumber;

    @Column(name = "field_description", nullable = false)
    private String fieldDescription;

}