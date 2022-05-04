package com.example.digitom.domain.task;

import com.example.digitom.domain.report.ReportRepository;
import com.example.digitom.domain.safetyfield.SafetyField;
import com.example.digitom.domain.safetyfield.SafetyFieldRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskService {

    @Resource
    private ReportRepository reportRepository;

    @Resource
    private SafetyFieldRepository safetyFieldRepository;

    public Task addNewTask (Integer safetyFiledId, Integer reportId) {
        Task task = new Task();
        task.setReport(reportRepository.findById(reportId).get());
        task.setSafetyField(safetyFieldRepository.findById(safetyFiledId).get());

    }

}
