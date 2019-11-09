package com.yx.rpc.api.dispatch;

import com.yx.pub.dto.RPCTransformObj;

import java.lang.reflect.Method;

/** 服务的分发 .当客户端请求的时候，用分发处理
 * @author yx start
 * @create 2019/11/9,13:13
 */
public class ServiceDispatch {

    public static Object dispatch(Object requestObj){
        /**
         * 这样弄写的太死
         * if(1){
         * userServiceImpl1.method
         * }
         * if(2){
         * }
         * ***********
         * 优雅的>反射的方式进行实现
         *  需要：1.类的全路径 2.方法名 3.参数列表
         */
        RPCTransformObj rpcTransformObj = (RPCTransformObj) requestObj;
        String fullClassName =rpcTransformObj.getFullClassName() ;
        String methodName = rpcTransformObj.getMethodName() ;
        Object[] args =rpcTransformObj.getArgs() ;

        // args 参数 的字节码，给getDeclaredMethod使用
        Class[]  types = new Class[args.length];
        for (int i = 0; i <args.length ; i++) {
            types[i] = args[i].getClass();
        }
        Class aClass ;
        Object respObj =null;
        try {
            aClass = Class.forName(fullClassName);
            Method method = aClass.getDeclaredMethod(methodName, types);
            respObj = method.invoke(aClass.newInstance(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respObj ;
    }

}
