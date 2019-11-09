package com.yx.rpc.proxy;

import com.yx.pub.dto.RPCTransformObj;
import com.yx.pub.rpc.ServierMapped;
import com.yx.rpc.net.BIOSocketClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** jdk动态代理使用
 * @author yx start
 * @create 2019/11/9,14:56
 */
public class RPCInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这个方法会在方法调用时调用这里。 return 的结果就是调用结果的返回
        // 可以输出相关的方法 method  args 进行测试
        /**
         * System.out.println("method==>"+method.getName());
         * System.out.println("args==>"+args.length);
         */
        // 我们可以进行socker 网络通信
        // 完成网络通信，远程方法的调用
        RPCTransformObj rpcTransformObj = new RPCTransformObj();
        rpcTransformObj.setArgs(args);
        rpcTransformObj.setMethodName(method.getName());
       //  rpcTransformObj.setFullClassName(); // 这里不知道具体全类名。采用 自定义注解在接口上。然后获取相关的注解处理
        // 处理全类名
        String annotationName = method.getDeclaringClass().getAnnotation(ServierMapped.class).mapperService();
        rpcTransformObj.setFullClassName( annotationName ) ;

        return  BIOSocketClient.callRemoteService(rpcTransformObj,"localhost",10086) ;
     }
}
