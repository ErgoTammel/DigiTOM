package com.example.digitom.domain.incident;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.example.digitom.domain.task.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IncidentService {

    @Resource
    private IncidentMapper incidentMapper;

    @Resource
    private IncidentRepository incidentRepository;

    @Resource
    private TaskService taskService;


    public Incident addNewIncident(IncidentRequest incidentRequest) {
        Incident incident = incidentMapper.incidentRequestToIncident(incidentRequest);
        if (!incident.getSafe()) {
            taskService.addNewTask(incident.getSafetyField().getId(), incident.getReport().getId());

        }


        incidentRepository.save(incident);
        return incident;
    }
}
