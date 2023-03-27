/*******************************************************************************
 * Package: com.lwlve.atp.common.entity
 * Type:    ResponseResult
 * Date:    2023/1/18 15:32
 *******************************************************************************/
package com.lwlve.atp.common.entity;

import com.lwlve.atp.common.emum.ResponseCode;
import com.lwlve.atp.common.emum.SystemResponseCode;
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
public class ResponseResult<T> {
    
    private String code;
    
    private String message;
    
    private T data;
    
    public ResponseResult (){}
    
    public ResponseResult(ResponseCode responseCode){
        this.setCode(responseCode.getCode());
        this.setMessage(responseCode.getMessage());
    }
    
    public static <T> ResponseResult<T> success(T data){
        return build(SystemResponseCode.SUCCESS,data);
    }
    
    public static <T> ResponseResult<T> fail(ResponseCode responseCode){
        return new ResponseResult<>(responseCode);
    }
    
    public static <T> ResponseResult<T> build(ResponseCode responseCode,T data){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(responseCode.getCode());
        result.setMessage(responseCode.getMessage());
        result.setData(data);
        return result;
    }
   
}
