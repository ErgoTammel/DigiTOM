package com.example.digitom.domain.company;

import com.example.digitom.service.account.RegistrationRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CompanyMapper {
    Company toEntity(CompanyDto companyDto);

    CompanyDto toDto(Company company);

    List<CompanyDto> toDtos(List<Company> companies);

    @Mapping(target = "name", source = "companyName")
    @Mapping(target = "regNumber", source = "companyNumber")
    Company registrationRequestToCompany(RegistrationRequest registrationRequest);



}
