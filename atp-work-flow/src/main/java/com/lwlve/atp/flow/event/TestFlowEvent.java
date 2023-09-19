package com.lwlve.atp.flow.event;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

/**
 * TODO your comment
 *
 * @author Liuzheng
 * @date 2023/9/18 11:12
 */
@Component
@Slf4j
public class TestFlowEvent implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        log.info("进入事件");
        String activityName = execution.getCurrentActivityName();
        String eventName = execution.getEventName();
        log.info("事件名称: {}",eventName);
        log.info("节点名称:{}",activityName);

    }
}
