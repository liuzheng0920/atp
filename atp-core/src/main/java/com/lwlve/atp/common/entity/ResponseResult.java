/*******************************************************************************
 * Package: com.lwlve.atp.common.entity
 * Type:    ResponseResult
 * Date:    2023/1/18 15:32
 *******************************************************************************/
package com.lwlve.atp.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 公共返回前端
 *
 * @author Liuzheng
 * @date 2023/1/18 15:32
 */

@Getter
@Setter
public class ResponseResult {
    
    private short code;
    
    private String msg;
    
    private Object data;
}
