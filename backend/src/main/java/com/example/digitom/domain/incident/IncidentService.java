package com.example.digitom.domain.incident;

import com.example.digitom.service.inspection.IncidentCounterResponse;
import com.example.digitom.service.inspection.IncidentRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IncidentService {

    @Resource
    private IncidentMapper incidentMapper;

    @Resource
    private IncidentRepository incidentRepository;

    public Integer addNewIncident(IncidentRequest incidentRequest) {
        Incident incident = incidentMapper.incidentRequestToIncident(incidentRequest);
        incidentRepository.save(incident);
        return incident.getId();
    }

    public Integer incidentCounter(IncidentCounterResponse incidentCounterResponse) {
        List<Incident> incidents = incidentRepository.findByReportIdAndSafetyFieldIdAndSafe
                (incidentCounterResponse.getReportId(), incidentCounterResponse.getSafetyFieldId(),
                        incidentCounterResponse.getSafe());
        return incidents.size();
    }

    public void removeTrueIncident(IncidentCounterResponse incidentCounterResponse) {

        Incident lastById = incidentRepository.findFirstByReport_IdAndSafetyField_IdAndSafeOrderByIdDesc
                (incidentCounterResponse.getReportId(),
                incidentCounterResponse.getSafetyFieldId(),
                incidentCounterResponse.getSafe());
        incidentRepository.delete(lastById);
    }
}
