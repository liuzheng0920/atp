package com.lwlve.atp.flow;

import com.lwlve.atp.AtpWorkFlowApplication;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ExecutionQuery;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 测试流程api
 *
 * @author Liuzheng
 * @date 2023/9/18 10:55
 */
@SpringBootTest(classes = AtpWorkFlowApplication.class)
@Slf4j
public class FlowTests {

    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void startFlow(){
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("F00001", "lcslbh002");
        log.info("启动流程实例id:{}",processInstance.getId());

    }
    // 96b81943-55d0-11ee-b450-00ff2cbcab8e
    @Test
    public void findDqjd(){
        List<Execution> list = runtimeService.createExecutionQuery().processInstanceBusinessKey("lcslbh001").list();
        list.forEach(execution -> log.info(execution.toString()));
    }

}
