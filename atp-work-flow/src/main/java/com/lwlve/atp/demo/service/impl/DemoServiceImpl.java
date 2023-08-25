/*******************************************************************************
 * Package: com.lwlve.atp.demo.service.impl
 * Type:    DemoServiceImpl
 * Date:    2023/1/18 15:38
 *******************************************************************************/
package com.lwlve.atp.demo.service.impl;

import com.lwlve.atp.demo.service.DemoService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO your comment
 *
 * @author Liuzheng
 * @date 2023/1/18 15:38
 */
@Service
public class DemoServiceImpl implements DemoService {
    
    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private TaskService taskService;
    @Override
    public void startFlow() {
    }
}
