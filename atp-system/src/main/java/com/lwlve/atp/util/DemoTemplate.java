package com.lwlve.atp.util;

import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 模版开发
 *
 * @author Liuzheng
 * @date 2023/8/10 10:48
 */
@Component
public class DemoTemplate {



    public String getTemplateContext(Map<String,Object> header,List<?> datas){
        TemplateConfig templateConfig = new TemplateConfig("static", TemplateConfig.ResourceMode.CLASSPATH);
        TemplateEngine engine = TemplateUtil.createEngine(templateConfig);
        Template template =  engine.getTemplate("template/sendEmail.ftl");
        Map<String, Object> bindingMap = Maps.newHashMap();
        bindingMap.put("header",header);
        bindingMap.put("datas",datas);
        return template.render(bindingMap);
    }
}
