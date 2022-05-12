package com.example.digitom.domain.constructionsite;

import com.example.digitom.service.constractionsitemanagement.NewConstructionSiteRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T13:54:43+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class ConstructionSiteMapperImpl implements ConstructionSiteMapper {

    @Override
    public ConstructionSite toEntity(ConstructionSiteDto constructionSiteDto) {
        if ( constructionSiteDto == null ) {
            return null;
        }

        ConstructionSite constructionSite = new ConstructionSite();

        constructionSite.setId( constructionSiteDto.getId() );
        constructionSite.setName( constructionSiteDto.getName() );
        constructionSite.setAddress( constructionSiteDto.getAddress() );
        constructionSite.setLatitude( constructionSiteDto.getLatitude() );
        constructionSite.setLongitude( constructionSiteDto.getLongitude() );

        return constructionSite;
    }

    @Override
    public ConstructionSiteDto toDto(ConstructionSite constructionSite) {
        if ( constructionSite == null ) {
            return null;
        }

        Integer id = null;
        String name = null;
        String address = null;
        Integer latitude = null;
        Integer longitude = null;

        id = constructionSite.getId();
        name = constructionSite.getName();
        address = constructionSite.getAddress();
        latitude = constructionSite.getLatitude();
        longitude = constructionSite.getLongitude();

        ConstructionSiteDto constructionSiteDto = new ConstructionSiteDto( id, name, address, latitude, longitude );

        return constructionSiteDto;
    }

    @Override
    public ConstructionSite requestToConstructionSite(NewConstructionSiteRequest newConstructionSiteRequest) {
        if ( newConstructionSiteRequest == null ) {
            return null;
        }

        ConstructionSite constructionSite = new ConstructionSite();

        return constructionSite;
    }
}
