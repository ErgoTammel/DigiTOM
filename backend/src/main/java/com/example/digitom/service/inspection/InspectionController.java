package com.example.digitom.service.inspection;

import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.service.account.NewInspectionConstructionSiteResponse;
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


    @GetMapping("/objects")
    public List<ConstructionSite> getConstructionSites(@RequestParam Integer userId) {
        return inspectionService.getConstructionSites(userId);
}
}
