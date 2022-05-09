package com.example.digitom.domain.company;

import com.example.digitom.service.account.RegistrationRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-08T22:38:44+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public Company toEntity(CompanyDto companyDto) {
        if ( companyDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( companyDto.getId() );
        company.setName( companyDto.getName() );
        company.setRegNumber( companyDto.getRegNumber() );

        return company;
    }

    @Override
    public CompanyDto toDto(Company company) {
        if ( company == null ) {
            return null;
        }

        Integer id = null;
        String name = null;
        Integer regNumber = null;

        id = company.getId();
        name = company.getName();
        regNumber = company.getRegNumber();

        CompanyDto companyDto = new CompanyDto( id, name, regNumber );

        return companyDto;
    }

    @Override
    public void updateCompanyFromCompanyDto(CompanyDto companyDto, Company company) {
        if ( companyDto == null ) {
            return;
        }

        if ( companyDto.getId() != null ) {
            company.setId( companyDto.getId() );
        }
        if ( companyDto.getName() != null ) {
            company.setName( companyDto.getName() );
        }
        if ( companyDto.getRegNumber() != null ) {
            company.setRegNumber( companyDto.getRegNumber() );
        }
    }

    @Override
    public Company registrationRequestToCompany(RegistrationRequest registrationRequest) {
        if ( registrationRequest == null ) {
            return null;
        }

        Company company = new Company();

        company.setName( registrationRequest.getCompanyName() );
        if ( registrationRequest.getCompanyNumber() != null ) {
            company.setRegNumber( Integer.parseInt( registrationRequest.getCompanyNumber() ) );
        }

        return company;
    }

    @Override
    public List<CompanyDto> toDtos(List<Company> companies) {
        if ( companies == null ) {
            return null;
        }

        List<CompanyDto> list = new ArrayList<CompanyDto>( companies.size() );
        for ( Company company : companies ) {
            list.add( toDto( company ) );
        }

        return list;
    }
}
