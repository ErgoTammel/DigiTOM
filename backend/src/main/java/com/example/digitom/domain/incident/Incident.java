package com.example.digitom.domain.incident;

import com.example.digitom.domain.report.Report;
import com.example.digitom.domain.safetyfield.SafetyField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "incident", schema = "digi_tom")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "safe", nullable = false)
    private Boolean safe = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "safety_field_id", nullable = false)
    private SafetyField safetyField;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

}