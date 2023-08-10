package com.lwlve.atp.template;

import com.google.common.collect.Maps;
import com.lwlve.atp.AtpApplication;
import com.lwlve.atp.util.DemoTemplate;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 模版测试类
 *
 * @author Liuzheng
 * @date 2023/8/10 11:28
 */
@SpringBootTest(classes = AtpApplication.class)
@Slf4j
public class DemoTemplateTests {

    @Resource
    private DemoTemplate demoTemplate;
    @Test
    public void demoTest(){
        Map<String,Object> header = Maps.newHashMap();
        header.put("ZZC",true);
        header.put("ZFZ",true);
        header.put("ZCJZ",true);
        header.put("ZFE",true);
        header.put("DWJZ",true);
        List datas = Lists.newArrayList();
        Map<String,Object> data = Maps.newHashMap();
        data.put("dqrq",new Date());
        data.put("cpmc","测试");
        data.put("zzc",new BigDecimal("10000000.3654"));
        datas.add(data);
        String templateContext = demoTemplate.getTemplateContext(header, datas);
        log.info(templateContext);
    }
}
