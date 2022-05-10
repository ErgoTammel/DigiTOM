package com.example.digitom.domain.companyconstructionsite;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CompanyConstructionSiteMapper {
    @InheritInverseConfiguration(name = "companyConstructionSiteDtoToCompanyConstructionSite")
    CompanyConstructionSiteDto companyConstructionSiteToCompanyConstructionSiteDto(CompanyConstructionSite companyConstructionSite);

    @Mapping(target = "companyConstructionSiteId", source = "id")
    @Mapping(target = "companyName", source = "company.name")
    @Mapping(target = "companyId", source = "company.id")
    CompanyConstructionSiteListResponse toCCSListResponse(CompanyConstructionSite companyConstructionSite);


    List<CompanyConstructionSiteListResponse> toCCSListResponses(List<CompanyConstructionSite> companyConstructionSites);


}
