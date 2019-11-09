package com.yx.rpc.net;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author yx start
 * @create 2019/11/9,15:11
 */
public class BIOSocketClient  {
    public  static Object  callRemoteService(Object reqObj,String host,int port){

        Object respObj = null ;
        try {
            ObjectInputStream ois = null ;
            ObjectOutputStream oos = null ;

            try {
                // 客户端 先写  ，后获取
                Socket socket = new Socket(host , port) ;
                oos = new ObjectOutputStream( socket.getOutputStream() );
                oos.writeObject(reqObj);
                oos.flush();

                ois = new ObjectInputStream(socket.getInputStream());
                respObj = ois.readObject();

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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return respObj ;
    }
}
