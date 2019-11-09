package com.yx.rpc.api.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yx start
 * @create 2019/11/9,13:36
 */
public class BIOSocketServer {

    // 启动线程池，处理alibaba手册禁止这样处理
   static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static  void startServer(int port) throws IOException {
        //开启服务端口监听
        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            Socket socket = serverSocket.accept();
            executorService.submit(new NetProcessHandler(socket));
        }
        // 得到输入输出流;由于io流阻塞操作的强绑定，没有办法同时接收多次请求，所以采用多线程处理
        /*InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();*/

    }

}
