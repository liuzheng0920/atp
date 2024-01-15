package com.lwlve.atp.sell.model;

import java.util.Date;

/**
 * SellBusiRequest
 *
 * @author Liuzheng
 * @date 2023/12/12 15:34
 */
/**
    * 业务申请类型定义表
    */
public class SellBusiRequest {
    /**
    * 序号，自增
    */
    private String requestId;

    /**
    * 代销机构代码
    */
    private String agencyCode;

    /**
    * 申请业务代码
    */
    private String requestCode;

    /**
    * 业务代码
    */
    private String busiCode;

    /**
    * 业务名称
    */
    private String busiName;

    /**
    * 文件类型
    */
    private String fileType;

    /**
    * 状态，1-有效，0-无效
    */
    private Integer usestate;

    /**
    * 新增人编号
    */
    private String inputUser;

    /**
    * 新增时间
    */
    private Date inputTime;

    /**
    * 修改人编号
    */
    private String updateUser;

    /**
    * 修改日期
    */
    private Date updateTime;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getUsestate() {
        return usestate;
    }

    public void setUsestate(Integer usestate) {
        this.usestate = usestate;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}