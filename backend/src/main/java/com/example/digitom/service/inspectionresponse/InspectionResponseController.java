package com.example.digitom.service.inspectionresponse;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/response")
public class InspectionResponseController {

    @Resource
    private InspectionResponseService inspectionResponseService;

    @PostMapping("/add")
    @Operation(summary = "Add new task response")
    public Integer addTaskResponse(@RequestBody TaskResponseRequest taskResponseRequest) {
        return inspectionResponseService.addTaskResponse(taskResponseRequest);
    }

    @GetMapping("/get/list")
    @Operation(summary = "Get open tasks list")
    public List<TaskOverviewResponse> getOpenTasksBySiteId(@RequestParam Integer constructionSiteId){
       return inspectionResponseService.getOpenTasksBySiteId(constructionSiteId);
    }

}
