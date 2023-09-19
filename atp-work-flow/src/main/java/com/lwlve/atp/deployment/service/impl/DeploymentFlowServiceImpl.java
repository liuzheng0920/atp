package com.lwlve.atp.deployment.service.impl;

import com.lwlve.atp.deployment.service.DeploymentFlowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.Deployment;
import org.springframework.stereotype.Service;

/**
 * 部署流程服务类
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DeploymentFlowServiceImpl implements DeploymentFlowService {

    private final RepositoryService repositoryService;

    @Override
    public void deploymentXmlStr(String resourceName,String xmlStr) {
        Deployment deploy = repositoryService.createDeployment().addString(resourceName+".bpmn20.xml", xmlStr).name(resourceName).deploy();
        log.info(deploy.getId());
    }
}
