package com.yx.rpc.api;

import com.yx.rpc.api.net.BIOSocketServer;

import java.io.IOException;

/**
 * @author yx start
 * @create 2019/11/9,14:06
 */
public class ProviderMain {

    public static void main(String[] args) throws IOException {
        // 启动服务器
        BIOSocketServer.startServer(10086);
    }
}
