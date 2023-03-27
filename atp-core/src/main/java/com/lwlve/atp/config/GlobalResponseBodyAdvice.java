package com.lwlve.atp.config;

import com.lwlve.atp.annotation.ResponseInfoWrapper;
import com.lwlve.atp.common.entity.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * 增加自定义统一返回应答
 *
 * @author Liuzheng
 * @date 2023/3/27 14:51
 */
@ControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    
    /**
     * 控制何时使用统一封装返回
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //如果方法中存在 ResponseInfoWrapper 注解 则封装返回
        ResponseInfoWrapper methodAnnotation = returnType.getMethodAnnotation(ResponseInfoWrapper.class);
        if(Objects.nonNull(methodAnnotation)){
            return true;
        }
        //如果类中存在 ResponseInfoWrapper 注解 则封装返回
        ResponseInfoWrapper classAnnotation = returnType.getExecutable().getDeclaringClass()
                .getAnnotation(ResponseInfoWrapper.class);
        
        return Objects.nonNull(classAnnotation);
    }
    
    /**
     * 处理拦截公共返回
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        
        //application/octet-stream 不处理
        if(MediaType.APPLICATION_OCTET_STREAM == selectedContentType){
            return body;
        }
        if(body instanceof ResponseResult){
            return body;
        }
        return ResponseResult.success(body);
    }
}
