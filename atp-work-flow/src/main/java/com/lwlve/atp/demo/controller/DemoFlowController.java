/*******************************************************************************
 * Package: com.lwlve.atp.demo.contraller
 * Type:    DemoFlowContraller
 * Date:    2023/1/18 15:26
 *******************************************************************************/
package com.lwlve.atp.demo.controller;

import com.lwlve.atp.annotation.ResponseInfoWrapper;
import com.lwlve.atp.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例 流程
 *
 * @author Liuzheng
 * @date 2023/1/18 15:26
 */

@RestController
@ResponseInfoWrapper
@RequestMapping("demo-flow")
public class DemoFlowController {
    
    @Autowired
    private DemoService demoService;

    @GetMapping("start-flow")
    public void startFlow(){
        demoService.startFlow();
    }

}
