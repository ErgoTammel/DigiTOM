package com.example.digitom.domain.companyconstructionsite;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.company.CompanyDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CompanyConstructionSiteMapper {
    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "companyName", target = "company.name")
    @Mapping(source = "companyRegNumber", target = "company.regNumber")
    @Mapping(source = "constructionSiteId", target = "constructionSite.id")
    @Mapping(source = "constructionSiteName", target = "constructionSite.name")
    @Mapping(source = "constructionSiteAddress", target = "constructionSite.address")
    @Mapping(source = "constructionSiteLatitude", target = "constructionSite.latitude")
    @Mapping(source = "constructionSiteLongitude", target = "constructionSite.longitude")
    CompanyConstructionSite companyConstructionSiteDtoToCompanyConstructionSite(CompanyConstructionSiteDto companyConstructionSiteDto);

    @InheritInverseConfiguration(name = "companyConstructionSiteDtoToCompanyConstructionSite")
    CompanyConstructionSiteDto companyConstructionSiteToCompanyConstructionSiteDto(CompanyConstructionSite companyConstructionSite);

    @InheritConfiguration(name = "companyConstructionSiteDtoToCompanyConstructionSite")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCompanyConstructionSiteFromCompanyConstructionSiteDto(CompanyConstructionSiteDto companyConstructionSiteDto, @MappingTarget CompanyConstructionSite companyConstructionSite);

    List<CompanyConstructionSiteDto> toDtos(List<CompanyConstructionSite> companyConstructionSites);


    @Mapping(target = "companyConstructionSiteId", source = "id")
    @Mapping(target = "companyName", source = "company.name")
    @Mapping(target = "companyId", source = "company.id")
    CompanyConstructionSiteListResponse toCCSListResponse(CompanyConstructionSite companyConstructionSite);


    List<CompanyConstructionSiteListResponse> toCCSListResponses(List<CompanyConstructionSite> companyConstructionSites);


}
