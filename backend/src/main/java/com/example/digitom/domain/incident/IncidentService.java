package com.example.digitom.domain.incident;

import com.example.digitom.service.inspection.IncidentRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IncidentService {

    @Resource
    private IncidentMapper incidentMapper;

    @Resource
    private IncidentRepository incidentRepository;


    public void addNewIncident(IncidentRequest incidentRequest) {
        Incident incident = incidentMapper.incidentRequestToIncident(incidentRequest);
        incidentRepository.save(incident);
    }

}
