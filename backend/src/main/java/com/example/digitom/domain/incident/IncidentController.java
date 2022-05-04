package com.example.digitom.domain.incident;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/incident")
public class IncidentController {

    @Resource
    private IncidentService incidentService;

    @PutMapping("/new")
    public Incident addNewIncident(@RequestBody IncidentRequest incidentRequest) {
        return incidentService.addNewIncident(incidentRequest);
    }

}
