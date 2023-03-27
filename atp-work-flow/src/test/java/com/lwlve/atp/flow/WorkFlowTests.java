/*******************************************************************************
 * Package: com.lwlve.atp.flow
 * Type:    WorkFlowTests
 * Date:    2023/1/20 19:25
 *******************************************************************************/
package com.lwlve.atp.flow;

import com.lwlve.atp.AtpWorkFlowApplication;
import liquibase.pro.packaged.A;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricDetail;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
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
    
    private RepositoryService repositoryService;
    
    @Test
    public void startFlow(){
        Map<String,Object> map = new HashMap<>();
        map.put("userId","zhangs");
        map.put("msg","开始流程信息");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("hello",map);
        String processInstanceId = processInstance.getProcessInstanceId();
        String businessStatus = processInstance.getBusinessStatus();
        log.info("流程实例启动成功:{},{}",processInstanceId,businessStatus);
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
