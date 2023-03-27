/*******************************************************************************
 * Package: com.lwlve.atp.demo.contraller
 * Type:    DemoFlowContraller
 * Date:    2023/1/18 15:26
 *******************************************************************************/
package com.lwlve.atp.demo.controller;

import com.lwlve.atp.common.entity.ResponseResult;
import com.lwlve.atp.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO your comment
 *
 * @author Liuzheng
 * @date 2023/1/18 15:26
 */

@RestController
@RequestMapping("demo-flow")
public class DemoFlowController {
    
    @Autowired
    private DemoService demoService;

    public ResponseResult startFlow(){
        return demoService.startFlow();
    }

}
