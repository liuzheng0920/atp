/*******************************************************************************
 * Package: com.lwlve.atp.flow
 * Type:    StartFlow
 * Date:    2023/1/20 19:20
 *******************************************************************************/
package com.lwlve.atp.flow;

import com.lwlve.atp.AtpWorkFlowApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO your comment
 *
 * @author Liuzheng
 * @date 2023/1/20 19:20
 */
@SpringBootTest(classes = AtpWorkFlowApplication.class)
@Slf4j
public class StartFlowTests {
    
    @Test
    public void startService(){
        log.info("测试服务是否正常");
    }


}
