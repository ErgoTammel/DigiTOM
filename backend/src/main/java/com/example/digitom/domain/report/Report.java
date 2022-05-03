package com.example.digitom.domain.report;

import com.example.digitom.domain.constructionsite.ConstructionSite;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "report", schema = "digi_tom")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "construction_site_id", nullable = false)
    private ConstructionSite constructionSite;

    @Column(name = "date", nullable = false)
    private LocalDate date;

}