/*******************************************************************************
 * Package: com.lwlve.atp.flow
 * Type:    WorkFlowTests
 * Date:    2023/1/20 19:25
 *******************************************************************************/
package com.lwlve.atp.flow;

import com.lwlve.atp.AtpWorkFlowApplication;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricDetail;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO your comment
 *
 * @author Liuzheng
 * @date 2023/1/20 19:25
 */
@SpringBootTest(classes = AtpWorkFlowApplication.class)
@Slf4j
public class WorkFlowTests {
    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private HistoryService historyService;

    @Autowired
    private RepositoryService repositoryService;


    @Test
    public void findFlow(){
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        List<ProcessDefinition> list1 = repositoryService.createProcessDefinitionQuery().list();
        for (Deployment deployment : list) {
            log.info("流程名称{}",deployment);
        }
        log.info("流程信息list{}",list);
        log.info("流程信息list1{}",list1);

    }
    
    @Test
    public void startFlow(){
        Map<String,Object> map = new HashMap<>();
        map.put("userId","zhangs");
        map.put("msg","开始流程信息");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Process_1iclvbm",map);
        String processInstanceId = processInstance.getProcessInstanceId();
        log.info("流程实例启动成功:{}",processInstanceId);
    }
    
    @Test
    public void findActive(){
        List<Task> activeList = taskService.createTaskQuery().active().list();
        activeList.forEach(active -> {
            log.info("获取活动流程信息:{},{}",active.getProcessDefinitionId(),active.getId());
        });
        List<Task> taskCandidateGroupList = taskService.createTaskQuery().taskCandidateGroup("3").active().list();
        taskCandidateGroupList.forEach(active ->{
            log.info("获取分组3的所有数据：{}",active.getProcessDefinitionId());
        });
    }
    
    @Test
    public void endActive(){
        taskService.complete("9885dbd2-9f9b-11ed-b057-005056c00008");
    }
    
    @Test
    public void findTask(){
        List<Task> taskList = taskService.createTaskQuery().list();
        taskList.forEach(task -> {
            log.info("获取活动流程信息:{},{}",task.getProcessDefinitionId(),task.getId());
    
        });
    }
    
    @Test
    public void findHistoryTask(){
        List<HistoricDetail> historicDetailList = historyService.createHistoricDetailQuery().list();
        historicDetailList.forEach(historicDetail -> {
            log.info("获取历史流程信息:{},{},{}",historicDetail.getProcessInstanceId(),historicDetail.getId(),historicDetail.getTaskId());
    
        });
    }
    
    @Test
    public void activeHistoryTask(){
    
    }
}
