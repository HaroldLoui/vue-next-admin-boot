package com.hw.demo;

import cn.hutool.crypto.SecureUtil;
import com.hw.demo.component.SnowFlakeIdWorker;
import com.hw.demo.entity.SysMenu;
import com.hw.demo.entity.SysUser;
import com.hw.demo.service.SysMenuService;
import com.hw.demo.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoTests {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SnowFlakeIdWorker idWorker;

    @Test
    public void test1() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword(SecureUtil.md5("123456").toUpperCase());
        sysUserService.save(sysUser);
    }

    @Test
    public void test2() {
        SysMenu sysMenu = SysMenu.builder()
                .path("/system/menu")
                .name("systemMenu")
                .component("system/menu/index")
                .parentId(1631920992937041922L)
                .type(0)
                .link("")
                .roles("admin")
                .title("message.router.systemMenu")
                .icon("iconfont icon-caidan")
                .isHide(0)
                .isAffix(0)
                .isIframe(0)
                .isLink(0)
                .isKeepAlive(0)
                .build();
        sysMenu.setCreateUser(1629428793682948097L);
        sysMenuService.save(sysMenu);
        SysMenu sysMenu1 = SysMenu.builder()
                .path("/system/user")
                .name("systemUser")
                .component("system/user/index")
                .parentId(1631920992937041922L)
                .type(0)
                .link("")
                .roles("admin")
                .title("message.router.systemUser")
                .icon("iconfont icon-icon-")
                .isHide(0)
                .isAffix(0)
                .isIframe(0)
                .isLink(0)
                .isKeepAlive(0)
                .build();
        sysMenu1.setCreateUser(1629428793682948097L);
        sysMenuService.save(sysMenu1);
    }

}
