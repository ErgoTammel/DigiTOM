package com.example.digitom.service.inspectionresponse;

import com.example.digitom.domain.taskresponse.TaskResponseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InspectionResponseService {

    @Resource
    private TaskResponseService taskResponseService;

    public Integer addTaskResponse(TaskResponseRequest taskResponseRequest) {
        return taskResponseService.addTaskResponse(taskResponseRequest);
    }
}
