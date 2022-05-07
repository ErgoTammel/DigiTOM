package com.example.digitom.domain.constructionsite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "construction_site", schema = "digi_tom")
public class ConstructionSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private Integer latitude;

    @Column(name = "longitude")
    private Integer longitude;

}