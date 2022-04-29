package com.example.digitom.domain.companyconstructionsite;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "company_construction_site", schema = "digi_tom")
public class CompanyConstructionSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "construction_site_id", nullable = false)
    private ConstructionSite constructionSite;

    @Column(name = "main_contractor", nullable = false)
    private Boolean mainContractor = false;

}