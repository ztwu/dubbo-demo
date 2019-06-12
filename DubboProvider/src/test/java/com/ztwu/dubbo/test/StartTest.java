package com.ztwu.dubbo.test;

import com.alibaba.dubbo.container.Main;
import com.alibaba.dubbo.container.spring.SpringContainer;

/**
 * created with idea
 * user:ztwu
 * date:2019/6/12
 * description
 */
public class StartTest {

    public static void main(String[] args) {
        //加载配置文件
        System.setProperty(SpringContainer.SPRING_CONFIG, "classpath*:app-context.xml");
        Main.main(args);
    }

}
