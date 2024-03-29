package com.lwlve.atp.util;

import cn.hutool.core.util.ReUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 模版开发
 *
 * @author Liuzheng
 * @date 2023/8/10 10:48
 */
@Component
@Slf4j
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

    public static void main(String[] args) throws JsonProcessingException {
        List<String> vo = new ArrayList<>();
        String json = "['1','2','3'],['1','2','3'],['1','2','3']";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);
        List list = objectMapper.readValue(json,List.class);
        System.out.println(list);
        // list.forEach(j -> System.out.println(j.toString()));

    }

}
