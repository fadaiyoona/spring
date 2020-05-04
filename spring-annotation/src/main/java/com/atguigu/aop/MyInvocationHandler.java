package com.atguigu.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-05-02 20:50
 */
public class MyInvocationHandler implements InvocationHandler {
    UserService userService;

    public MyInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        method.invoke(userService, args);
        return null;
    }
}
