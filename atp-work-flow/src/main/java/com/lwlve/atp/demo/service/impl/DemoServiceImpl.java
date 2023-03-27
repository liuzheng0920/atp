/*******************************************************************************
 * Package: com.lwlve.atp.demo.service.impl
 * Type:    DemoServiceImpl
 * Date:    2023/1/18 15:38
 *******************************************************************************/
package com.lwlve.atp.demo.service.impl;

import com.lwlve.atp.common.entity.ResponseResult;
import com.lwlve.atp.demo.service.DemoService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
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
        Map<String,Object> param = new HashMap<>();
        param.put("userId","admin");
        param.put("order","1");
    }
}
