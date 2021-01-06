package com.yfl.livedata.refrect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.refrect
 * @Email : yufeilong92@163.com
 * @Time :2021/1/5 15:36
 * @Purpose :
 */
public class MarkCompanyJava implements InvocationHandler {
    private Object mFactory;

    public void setMarkCompanyJava(Object mFactory) {
        this.mFactory = mFactory;
    }


    public Object getInstance() {
        return Proxy.newProxyInstance(mFactory.getClass().getClassLoader(), mFactory.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(mFactory, args);
        return invoke;
    }
}
