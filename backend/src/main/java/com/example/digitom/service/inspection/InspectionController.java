package com.example.digitom.service.inspection;

import com.example.digitom.domain.incident.Incident;
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

    @PostMapping("/new")
    public void addNewIncident(@RequestBody IncidentRequest incidentRequest) {
         inspectionService.addNewIncident(incidentRequest);
    }
}