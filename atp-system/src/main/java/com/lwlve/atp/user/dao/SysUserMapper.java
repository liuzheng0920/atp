package com.lwlve.atp.user.dao;

import com.lwlve.atp.user.model.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * SysUserMapper
 *
 * @author Liuzheng
 * @date 2023/12/12 16:07
 */
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    int batchInsert(@Param("list") List<SysUser> list);

    void deleteSex(@Param("sex") String sex);

    List<SysUser> selectBySex(String sex);
}
