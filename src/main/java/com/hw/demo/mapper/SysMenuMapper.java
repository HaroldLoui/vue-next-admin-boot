package com.hw.demo.mapper;

import com.hw.demo.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanwei
* @description 针对表【sys_menu(系统菜单表)】的数据库操作Mapper
* @createDate 2023-03-02 20:06:32
* @Entity com.hw.demo.entity.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}




