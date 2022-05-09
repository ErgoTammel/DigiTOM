package com.example.digitom.service.inspectionresponse;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/response")
public class InspectionResponseController {

    @Resource
    private InspectionResponseService inspectionResponseService;

    @PostMapping
    @Operation(summary = "Add new task response")
    public Integer addTaskResponse(@RequestBody TaskResponseRequest taskResponseRequest) {
        return inspectionResponseService.addTaskResponse(taskResponseRequest);
    }

}
