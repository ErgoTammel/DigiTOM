package com.example.digitom.domain.incident;

import com.example.digitom.domain.task.TaskRequest;
import com.example.digitom.domain.task.TaskService;
import com.example.digitom.service.inspection.IncidentRequest;
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


    public void addNewIncident(IncidentRequest incidentRequest) {
        Incident incident = incidentMapper.incidentRequestToIncident(incidentRequest);
        incidentRepository.save(incident);
    }


//        if (!incident.getSafe()) {
//            TaskRequest taskRequest = new TaskRequest();
//            taskService.addNewTask(incident.getSafetyField().getId(), incident.getReport().getId(), taskRequest);
//
//        }
//        incidentRepository.save(incident);
//
//
//    }
}
