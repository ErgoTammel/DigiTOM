package com.example.digitom.domain.companyconstructionsite;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-04T14:20:04+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class CompanyConstructionSiteMapperImpl implements CompanyConstructionSiteMapper {

    @Override
    public CompanyConstructionSite companyConstructionSiteDtoToCompanyConstructionSite(CompanyConstructionSiteDto companyConstructionSiteDto) {
        if ( companyConstructionSiteDto == null ) {
            return null;
        }

        CompanyConstructionSite companyConstructionSite = new CompanyConstructionSite();

        companyConstructionSite.setCompany( companyConstructionSiteDtoToCompany( companyConstructionSiteDto ) );
        companyConstructionSite.setConstructionSite( companyConstructionSiteDtoToConstructionSite( companyConstructionSiteDto ) );
        companyConstructionSite.setId( companyConstructionSiteDto.getId() );
        companyConstructionSite.setMainContractor( companyConstructionSiteDto.getMainContractor() );

        return companyConstructionSite;
    }

    @Override
    public CompanyConstructionSiteDto companyConstructionSiteToCompanyConstructionSiteDto(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }

        Integer companyId = null;
        String companyName = null;
        Integer companyRegNumber = null;
        Integer constructionSiteId = null;
        String constructionSiteName = null;
        String constructionSiteAddress = null;
        Integer constructionSiteLatitude = null;
        Integer constructionSiteLongitude = null;
        Integer id = null;
        Boolean mainContractor = null;

        companyId = companyConstructionSiteCompanyId( companyConstructionSite );
        companyName = companyConstructionSiteCompanyName( companyConstructionSite );
        companyRegNumber = companyConstructionSiteCompanyRegNumber( companyConstructionSite );
        constructionSiteId = companyConstructionSiteConstructionSiteId( companyConstructionSite );
        constructionSiteName = companyConstructionSiteConstructionSiteName( companyConstructionSite );
        constructionSiteAddress = companyConstructionSiteConstructionSiteAddress( companyConstructionSite );
        constructionSiteLatitude = companyConstructionSiteConstructionSiteLatitude( companyConstructionSite );
        constructionSiteLongitude = companyConstructionSiteConstructionSiteLongitude( companyConstructionSite );
        id = companyConstructionSite.getId();
        mainContractor = companyConstructionSite.getMainContractor();

        CompanyConstructionSiteDto companyConstructionSiteDto = new CompanyConstructionSiteDto( id, companyId, companyName, companyRegNumber, constructionSiteId, constructionSiteName, constructionSiteAddress, constructionSiteLatitude, constructionSiteLongitude, mainContractor );

        return companyConstructionSiteDto;
    }

    @Override
    public void updateCompanyConstructionSiteFromCompanyConstructionSiteDto(CompanyConstructionSiteDto companyConstructionSiteDto, CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSiteDto == null ) {
            return;
        }

        if ( companyConstructionSite.getCompany() == null ) {
            companyConstructionSite.setCompany( new Company() );
        }
        companyConstructionSiteDtoToCompany1( companyConstructionSiteDto, companyConstructionSite.getCompany() );
        if ( companyConstructionSite.getConstructionSite() == null ) {
            companyConstructionSite.setConstructionSite( new ConstructionSite() );
        }
        companyConstructionSiteDtoToConstructionSite1( companyConstructionSiteDto, companyConstructionSite.getConstructionSite() );
        if ( companyConstructionSiteDto.getId() != null ) {
            companyConstructionSite.setId( companyConstructionSiteDto.getId() );
        }
        if ( companyConstructionSiteDto.getMainContractor() != null ) {
            companyConstructionSite.setMainContractor( companyConstructionSiteDto.getMainContractor() );
        }
    }

    @Override
    public List<CompanyConstructionSiteDto> toDtos(List<CompanyConstructionSite> companyConstructionSites) {
        if ( companyConstructionSites == null ) {
            return null;
        }

        List<CompanyConstructionSiteDto> list = new ArrayList<CompanyConstructionSiteDto>( companyConstructionSites.size() );
        for ( CompanyConstructionSite companyConstructionSite : companyConstructionSites ) {
            list.add( companyConstructionSiteToCompanyConstructionSiteDto( companyConstructionSite ) );
        }

        return list;
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

    protected Company companyConstructionSiteDtoToCompany(CompanyConstructionSiteDto companyConstructionSiteDto) {
        if ( companyConstructionSiteDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( companyConstructionSiteDto.getCompanyId() );
        company.setName( companyConstructionSiteDto.getCompanyName() );
        company.setRegNumber( companyConstructionSiteDto.getCompanyRegNumber() );

        return company;
    }

    protected ConstructionSite companyConstructionSiteDtoToConstructionSite(CompanyConstructionSiteDto companyConstructionSiteDto) {
        if ( companyConstructionSiteDto == null ) {
            return null;
        }

        ConstructionSite constructionSite = new ConstructionSite();

        constructionSite.setId( companyConstructionSiteDto.getConstructionSiteId() );
        constructionSite.setName( companyConstructionSiteDto.getConstructionSiteName() );
        constructionSite.setAddress( companyConstructionSiteDto.getConstructionSiteAddress() );
        constructionSite.setLatitude( companyConstructionSiteDto.getConstructionSiteLatitude() );
        constructionSite.setLongitude( companyConstructionSiteDto.getConstructionSiteLongitude() );

        return constructionSite;
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

    private Integer companyConstructionSiteCompanyRegNumber(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }
        Company company = companyConstructionSite.getCompany();
        if ( company == null ) {
            return null;
        }
        Integer regNumber = company.getRegNumber();
        if ( regNumber == null ) {
            return null;
        }
        return regNumber;
    }

    private Integer companyConstructionSiteConstructionSiteId(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }
        ConstructionSite constructionSite = companyConstructionSite.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        Integer id = constructionSite.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String companyConstructionSiteConstructionSiteName(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }
        ConstructionSite constructionSite = companyConstructionSite.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        String name = constructionSite.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String companyConstructionSiteConstructionSiteAddress(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }
        ConstructionSite constructionSite = companyConstructionSite.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        String address = constructionSite.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private Integer companyConstructionSiteConstructionSiteLatitude(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }
        ConstructionSite constructionSite = companyConstructionSite.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        Integer latitude = constructionSite.getLatitude();
        if ( latitude == null ) {
            return null;
        }
        return latitude;
    }

    private Integer companyConstructionSiteConstructionSiteLongitude(CompanyConstructionSite companyConstructionSite) {
        if ( companyConstructionSite == null ) {
            return null;
        }
        ConstructionSite constructionSite = companyConstructionSite.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        Integer longitude = constructionSite.getLongitude();
        if ( longitude == null ) {
            return null;
        }
        return longitude;
    }

    protected void companyConstructionSiteDtoToCompany1(CompanyConstructionSiteDto companyConstructionSiteDto, Company mappingTarget) {
        if ( companyConstructionSiteDto == null ) {
            return;
        }

        if ( companyConstructionSiteDto.getCompanyId() != null ) {
            mappingTarget.setId( companyConstructionSiteDto.getCompanyId() );
        }
        if ( companyConstructionSiteDto.getCompanyName() != null ) {
            mappingTarget.setName( companyConstructionSiteDto.getCompanyName() );
        }
        if ( companyConstructionSiteDto.getCompanyRegNumber() != null ) {
            mappingTarget.setRegNumber( companyConstructionSiteDto.getCompanyRegNumber() );
        }
    }

    protected void companyConstructionSiteDtoToConstructionSite1(CompanyConstructionSiteDto companyConstructionSiteDto, ConstructionSite mappingTarget) {
        if ( companyConstructionSiteDto == null ) {
            return;
        }

        if ( companyConstructionSiteDto.getConstructionSiteId() != null ) {
            mappingTarget.setId( companyConstructionSiteDto.getConstructionSiteId() );
        }
        if ( companyConstructionSiteDto.getConstructionSiteName() != null ) {
            mappingTarget.setName( companyConstructionSiteDto.getConstructionSiteName() );
        }
        if ( companyConstructionSiteDto.getConstructionSiteAddress() != null ) {
            mappingTarget.setAddress( companyConstructionSiteDto.getConstructionSiteAddress() );
        }
        if ( companyConstructionSiteDto.getConstructionSiteLatitude() != null ) {
            mappingTarget.setLatitude( companyConstructionSiteDto.getConstructionSiteLatitude() );
        }
        if ( companyConstructionSiteDto.getConstructionSiteLongitude() != null ) {
            mappingTarget.setLongitude( companyConstructionSiteDto.getConstructionSiteLongitude() );
        }
    }
}
