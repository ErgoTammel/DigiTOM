package com.example.digitom.domain.companyconstructionsite;

import com.example.digitom.domain.company.Company;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T11:51:53+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class CompanyConstructionSiteMapperImpl implements CompanyConstructionSiteMapper {

    @Override
    public CompanyConstructionSiteDto companyConstructionSiteToCompanyConstructionSiteDto(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }

        Integer id = null;
        Boolean mainContractor = null;

        id = companyConstructionSite.getId();
        mainContractor = companyConstructionSite.getMainContractor();

        Integer companyId = null;
        String companyName = null;
        Integer companyRegNumber = null;
        Integer constructionSiteId = null;
        String constructionSiteName = null;
        String constructionSiteAddress = null;
        Integer constructionSiteLatitude = null;
        Integer constructionSiteLongitude = null;

        CompanyConstructionSiteDto companyConstructionSiteDto = new CompanyConstructionSiteDto( id, companyId, companyName, companyRegNumber, constructionSiteId, constructionSiteName, constructionSiteAddress, constructionSiteLatitude, constructionSiteLongitude, mainContractor );

        return companyConstructionSiteDto;
    }

    @Override
    public CompanyConstructionSiteListResponse toCCSListResponse(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }

        CompanyConstructionSiteListResponse companyConstructionSiteListResponse = new CompanyConstructionSiteListResponse();

        companyConstructionSiteListResponse.setCompanyConstructionSiteId( companyConstructionSite.getId() );
        companyConstructionSiteListResponse.setCompanyName( companyConstructionSiteCompanyName( companyConstructionSite ) );
        companyConstructionSiteListResponse.setCompanyId( companyConstructionSiteCompanyId( companyConstructionSite ) );

        return companyConstructionSiteListResponse;
    }

    @Override
    public List<CompanyConstructionSiteListResponse> toCCSListResponses(List<CompanyConstructionSite> companyConstructionSites) {
        if ( companyConstructionSites == null ) {
            return null;
        }

        List<CompanyConstructionSiteListResponse> list = new ArrayList<CompanyConstructionSiteListResponse>( companyConstructionSites.size() );
        for ( CompanyConstructionSite companyConstructionSite : companyConstructionSites ) {
            list.add( toCCSListResponse( companyConstructionSite ) );
        }

        return list;
    }

    private String companyConstructionSiteCompanyName(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }
        Company company = companyConstructionSite.getCompany();
        if ( company == null ) {
            return null;
        }
        String name = company.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Integer companyConstructionSiteCompanyId(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }
        Company company = companyConstructionSite.getCompany();
        if ( company == null ) {
            return null;
        }
        Integer id = company.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
