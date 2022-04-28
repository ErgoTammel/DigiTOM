package com.example.digitom.domain.company;

import com.example.digitom.domain.contact.Contact;
import com.example.digitom.service.registration.RegistrationRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CompanyMapper {
    Company toEntity(CompanyDto companyDto);

    CompanyDto toDto(Company company);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCompanyFromCompanyDto(CompanyDto companyDto, @MappingTarget Company company);

    @Mapping(target="name", source = "companyName")
    @Mapping(target="regNumber", source = "companyNumber")
    Company registrationRequestToCompany(RegistrationRequest registrationRequest);
}
