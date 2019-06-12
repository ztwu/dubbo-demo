/*
 * 文件名：IUserService.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IUserService.java
 * 修改人：xiaofan
 * 修改时间：2017年3月19日
 * 修改内容：新增
 */
package com.ztwu.dubbo.service;

import com.ztwu.dubbo.domain.dto.UserDo;

/**
 * 利用SpringJDBC操作数据库.
 * 
 * @author xiaofan
 */
public interface IUserService {
    int insert(UserDo userDo);

    String selectByID(String id);

    UserDo selectByID(UserDo userDo);

    int update(UserDo userDo);

    int delete(UserDo userDo);
}
