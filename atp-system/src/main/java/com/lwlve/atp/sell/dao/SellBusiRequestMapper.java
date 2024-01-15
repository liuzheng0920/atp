package com.lwlve.atp.sell.dao;

import com.lwlve.atp.sell.model.SellBusiRequest;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * SellBusiRequestMapper
 *
 * @author Liuzheng
 * @date 2023/12/12 15:34
 */
public interface SellBusiRequestMapper {
    int deleteByPrimaryKey(String requestId);

    int insert(SellBusiRequest record);

    int insertSelective(SellBusiRequest record);

    SellBusiRequest selectByPrimaryKey(String requestId);

    int updateByPrimaryKeySelective(SellBusiRequest record);

    int updateByPrimaryKey(SellBusiRequest record);

    int batchInsert(@Param("list") List<SellBusiRequest> list);
}