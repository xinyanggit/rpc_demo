package com.yx.pub.rpc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yx start
 * @create 2019/11/9,15:03
 */
// 表示运行级别
@Retention(RetentionPolicy.RUNTIME)
// 类上面使用
@Target(ElementType.TYPE)
public @interface ServierMapped {
    String mapperService();
}
