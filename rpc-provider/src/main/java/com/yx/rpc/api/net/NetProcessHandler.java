package com.yx.rpc.api.net;

import com.yx.rpc.api.dispatch.ServiceDispatch;

import java.io.*;
import java.net.Socket;

/**
 * @author yx start
 * @create 2019/11/9,13:50
 */
public class NetProcessHandler implements  Runnable {
   private Socket socket ;


    public NetProcessHandler(Socket socket) {
        this.socket = socket;
    }

    // 通过 io流读取。然后调用  dispatch 分发。最后将结果用输出流写向客户端
    @Override
    public void run() {
        ObjectInputStream ois = null ;
        ObjectOutputStream oos = null ;
        try {

            ois = new ObjectInputStream(socket.getInputStream());
            Object obj = ServiceDispatch.dispatch(ois.readObject());

            oos = new ObjectOutputStream( socket.getOutputStream() );
            oos.writeObject(obj);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
