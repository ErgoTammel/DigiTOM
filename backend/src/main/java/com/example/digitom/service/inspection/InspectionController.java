package com.example.digitom.service.inspection;

import com.example.digitom.domain.incident.Incident;
import com.example.digitom.domain.task.TaskRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/inspection")
public class InspectionController {

    @Resource
    private InspectionService inspectionService;


    @GetMapping("/sites")
    public List<NewInspectionConstructionSiteResponse> getConstructionSites(@RequestParam Integer userId) {
        return inspectionService.getConstructionSites(userId);
    }

    @PostMapping("/incident/new")
    public Integer addNewIncident(@RequestBody IncidentRequest incidentRequest) {
       return inspectionService.addNewIncident(incidentRequest);
    }

    @PostMapping("/task/new")
    public void addNewTask(@RequestBody TaskRequest taskRequest) {
        inspectionService.addNewTask(taskRequest);
    }

    @PostMapping("/counter/incident")
    public Integer incidentCounter(@RequestBody IncidentCounterResponse incidentCounterResponse) {
        return inspectionService.incidentCounter(incidentCounterResponse);
    }


//    @PostMapping("/new/picture")
//    public void addNewReportPicture()
}