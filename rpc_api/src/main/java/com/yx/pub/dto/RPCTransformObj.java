package com.yx.pub.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用于类反射使用，需要三个参数
 * @author yx start
 * @create 2019/11/9,13:19
 */
@Data
public class RPCTransformObj implements Serializable {
    private static final long serialVersionUID = 3764136000322024186L;
    private String fullClassName;
    private String methodName ;
    private Object[] args ;
}
