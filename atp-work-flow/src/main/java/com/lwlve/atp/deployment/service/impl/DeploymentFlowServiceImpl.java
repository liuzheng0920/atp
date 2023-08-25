package com.lwlve.atp.deployment.service.impl;

import com.lwlve.atp.deployment.service.DeploymentFlowService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RepositoryService;
import org.springframework.stereotype.Service;

/**
 * 部署流程服务类
 */
@Service
@RequiredArgsConstructor
public class DeploymentFlowServiceImpl implements DeploymentFlowService {

    private final RepositoryService repositoryService;
    @Override
    public void deploymentXmlStr(String resourceName,String xmlStr) {
        repositoryService.createDeployment().addString(resourceName,xmlStr).deploy();
    }
}
