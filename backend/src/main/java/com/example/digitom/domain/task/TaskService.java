package com.example.digitom.domain.task;

import com.example.digitom.domain.report.ReportRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskService {

    @Resource
    private ReportRepository reportRepository;

    @Resource
    private TaskRepository taskRepository;


}
