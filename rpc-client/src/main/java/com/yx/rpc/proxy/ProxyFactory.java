package com.yx.rpc.proxy;

import com.yx.pub.rpc.UserService;

import java.lang.reflect.Proxy;

/** 工厂方法
 * @author yx start
 * @create 2019/11/9,14:48
 */
public class ProxyFactory {

    /**
     * 利用泛型处理
     * @param interfaceClass
     * @param <T>
     * @return
     */
    public  static <T> T getProxy(Class<T> interfaceClass ){
        // 通过接口，获取相关的实现类，这里可以用jdk动态代理弄
        Object o = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),
                new Class[]{interfaceClass}, new RPCInvocationHandler());
        return (T) o;
    }
}
