package com.lwlve.atp.user.model;

/**
 * SysUser
 *
 * @author Liuzheng
 * @date 2023/12/12 16:07
 */
/**
    * 用户表
    */
public class SysUser {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 用户id
    */
    private String userid;

    /**
    * 用户名
    */
    private String username;

    /**
    * 性别
    */
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}