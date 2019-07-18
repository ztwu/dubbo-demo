/*
 * 文件名：UserServiceImpl.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserServiceImpl.java
 * 修改人：xiaofan
 * 修改时间：2017年3月19日
 * 修改内容：新增
 */
package com.ztwu.dubbo.service.impl;

import com.ztwu.dubbo.domain.dto.UserDo;
import com.ztwu.dubbo.service.IUserService;
import com.ztwu.dubbo.persistence.IUserBusiness;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * 
 * @author xiaofan
 */
@Path("demo2")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserBusiness userBusiness;

    /**
     * {@inheritDoc}.
     */
    @Override
    public int insert(UserDo userDo) {
        int result = userBusiness.insert(userDo);
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    @GET
    @Path("greeting")
    @Produces("application/json; charset=UTF-8")
    public UserDo selectByID(UserDo userDo) {
        UserDo result = userBusiness.selectByID(userDo);
        return result;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int update(UserDo userDo) {
        return userBusiness.update(userDo);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int delete(UserDo userDo) {
        return userBusiness.delete(userDo);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String selectByID(String id) {
        UserDo userDo = new UserDo();
        userDo.setTableName("user");
        userDo.setId(Integer.valueOf(id));
        UserDo result = userBusiness.selectByID(userDo);
        if (null != result) {
            return result.toString();
        } else {
            return "No Result!";
        }
    }

}
