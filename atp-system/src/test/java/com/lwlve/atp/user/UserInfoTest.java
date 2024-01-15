package com.lwlve.atp.user;

import com.lwlve.atp.AtpApplication;
import com.lwlve.atp.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO your comment
 *
 * @author Liuzheng
 * @date 2023/12/14 11:16
 */

@SpringBootTest(classes = AtpApplication.class)
@Slf4j
public class UserInfoTest {

    private SysUserService sysUserService;

    @Test
    public void testSysnc(){
        sysUserService.syncUserInfo();
    }
}
