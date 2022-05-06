package com.example.digitom.service.inspection;

import com.example.digitom.domain.task.TaskRequest;
import com.example.digitom.service.image.ReportPictureRequest;
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
    public Integer addNewTask(@RequestBody TaskRequest taskRequest) {
        return inspectionService.addNewTask(taskRequest);
    }

    @PostMapping("/counter/incident")
    public Integer incidentCounter(@RequestBody IncidentCounterRequest incidentCounterRequest) {
        return inspectionService.incidentCounter(incidentCounterRequest);
    }

    @DeleteMapping("/counter/incident")
    public void removeTrueIncident(@RequestBody IncidentCounterRequest incidentCounterRequest) {
        inspectionService.removeTrueIncident(incidentCounterRequest);
    }

    @PostMapping("/new/picture")
    public void addNewReportPicture(@RequestBody ReportPictureRequest reportPictureRequest) {
        inspectionService.addNewReportPicture(reportPictureRequest);
    }

    @DeleteMapping("/report")
    public void removeReport(@RequestParam Integer reportId) {
        inspectionService.removeReport(reportId);
    }

    @PostMapping("/incident/false")
    public List<RemoveFalseIncidentList> getRemoveFalseIncidentList(@RequestBody IncidentCounterRequest incidentCounterRequest) {
        return inspectionService.getRemoveFalseIncidentList(incidentCounterRequest);
    }

    @DeleteMapping("/incident")
    public void removeFalseIncident(@RequestParam Integer taskId) {
        inspectionService.removeFalseIncident(taskId);
    }

    @PostMapping("/report/overview")
    public List<ReportOverviewResponse> getReportOverview(@RequestParam Integer reportId) {
        return inspectionService.getReportOverview(reportId);
    }

}