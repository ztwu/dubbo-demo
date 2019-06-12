/*
 * 文件名：ConsumerServiceImpl.java
 * 版权：Copyright 2007-2017 zxiaofan.com. Co. Ltd. All Rights Reserved. 
 * 描述： ConsumerServiceImpl.java
 * 修改人：zxiaofan
 * 修改时间：2017年3月15日
 * 修改内容：新增
 */
package com.ztwu.dubbo.service.impl;

import javax.annotation.Resource;

import com.ztwu.dubbo.domain.dto.HelloBo;
import com.ztwu.dubbo.service.IConsumerService;
import com.ztwu.dubbo.service.IProviderService;
import com.ztwu.dubbo.service.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author zxiaofan
 */
@Component("consumerService")
public class ConsumerServiceImpl implements IConsumerService {
    @Resource(name = "providerService")
    private IProviderService providerService;

    @Resource(name = "userService")
    private IUserService userService;

    @Value("${param.url}")
    private String url;

    /**
     * {@inheritDoc}.
     */
    @Override
    public String hi(String name) {
        String result = null;
        if (null != name && name.startsWith("boy")) {
            System.out.println("Hi Boy!");
            result = providerService.helloBoy(name.replace("boy", "~~~"));
        } else if (null != name && name.startsWith("select")) {
            System.out.println("hi select!");
            result = userService.selectByID(name.replace("select", ""));
            return result;
        } else {
            HelloBo helloBo = new HelloBo();
            helloBo.setName(name);
            HelloBo helloBoResult = null;
            helloBoResult = providerService.helloGirl(helloBo);
            if (null != helloBoResult) {
                result = helloBoResult.getUrl();
            }
        }
        result += "; This is dubboConsumer[" + url + "]";
        return result;
    }

}
