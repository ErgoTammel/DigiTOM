package com.example.digitom.service.inspectionresponse;

import com.example.digitom.domain.task.TaskService;
import com.example.digitom.domain.taskresponse.TaskResponseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InspectionResponseService {

    @Resource
    private TaskResponseService taskResponseService;
    @Resource
    private TaskService taskService;

    public Integer addTaskResponse(TaskResponseRequest taskResponseRequest) {
        return taskResponseService.addTaskResponse(taskResponseRequest);
    }

    public List<TaskOverviewResponse> getOpenTasks(Integer companyId, Boolean isDone) {
        return taskService.getOpenTasks(companyId, isDone);
    }
}
