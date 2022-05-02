package com.example.digitom.service.inspection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
