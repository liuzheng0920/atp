package com.lwlve.atp.deployment.controller;


import com.lwlve.atp.annotation.ResponseInfoWrapper;
import com.lwlve.atp.deployment.service.DeploymentFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deployment-flow")
@ResponseInfoWrapper
@RequiredArgsConstructor
public class DeploymentFlowController {

    private final DeploymentFlowService deploymentFlowService;
    @PostMapping("/deployment-xml-str")
    public void deploymentXmlStr(@RequestParam("resourceName")String resourceName,@RequestParam("xmlStr") String xmlStr){
        deploymentFlowService.deploymentXmlStr(resourceName,xmlStr);
    }

}
