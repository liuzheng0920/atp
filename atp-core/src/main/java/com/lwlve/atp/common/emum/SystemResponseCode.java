package com.lwlve.atp.common.emum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统字典值
 *
 * @author Liuzheng
 * @date 2023/3/27 15:39
 */
@Getter
@AllArgsConstructor
public enum SystemResponseCode implements ResponseCode{
    /**
     * 操作成功
     */
    SUCCESS("1","操作成功"),;
    
    private final String code;
    
    private final String message;
}
