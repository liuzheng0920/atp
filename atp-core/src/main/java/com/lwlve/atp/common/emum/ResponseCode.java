package com.lwlve.atp.common.emum;

/**
 * 错误码接口
 *
 * @author Liuzheng
 * @date 2023/3/27 15:22
 */


public interface ResponseCode {
    
    /**
     * 错误码
     * @return
     */
    String getCode();
    
    /**
     * 错误信息
     * @return
     */
    String getMessage();
}
