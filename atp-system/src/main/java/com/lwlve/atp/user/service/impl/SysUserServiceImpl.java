package com.lwlve.atp.user.service.impl;

import cn.hutool.core.util.IdUtil;
import com.google.common.collect.Lists;
import com.lwlve.atp.user.dao.SysUserMapper;
import com.lwlve.atp.user.model.SysUser;
import com.lwlve.atp.user.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO your comment
 *
 * @author Liuzheng
 * @date 2023/12/12 15:45
 */
@Service
@Slf4j
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private final SysUserMapper sysUserMapper;

    private final SysUserService sysUserService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAndDelAndSelect() {

        String sex = "1";

        sysUserMapper.deleteSex(sex);

        List<SysUser> addSysUser = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            SysUser sysUser = new SysUser();
            long id = IdUtil.getSnowflakeNextId();
            sysUser.setId((int) id);
            sysUser.setSex("1");
            sysUser.setUsername("张三");
            sysUser.setUserid("zhangs");
            addSysUser.add(sysUser);
        }
        sysUserMapper.batchInsert(addSysUser);

        List<SysUser> sysUsers = sysUserMapper.selectBySex(sex);
        Integer sum = sysUsers.stream().map(sysUser -> Integer.parseInt(sysUser.getSex())).reduce(Integer::sum).orElse(0);
        log.info("总人数sum = {} ",sum);


    }

    @Override
    public void syncUserInfo() {
        sysUserService.addAndDelAndSelect();
    }
}
