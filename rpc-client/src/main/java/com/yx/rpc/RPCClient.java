package com.yx.rpc;

import com.yx.pub.dto.UserDTO;
import com.yx.pub.rpc.UserService;
import com.yx.rpc.proxy.ProxyFactory;

/**
 * Hello world!
 *
 */
public class RPCClient
{
    public static void main( String[] args )
    {
        // 1. UserService userService = new User ..;
        // 2.UserService userService = ProxyFactory.getProxy(UserService.class);
        // 3.引入泛型
        UserService userService = ProxyFactory.getProxy(UserService.class);
        UserDTO userDTO  = new UserDTO() ;
        userDTO.setAge(100);
        userDTO.setUserName("yxyxyx");
        UserDTO userDTO1 = userService.addUser(userDTO);
        System.out.println( "Hello World!" );
        System.out.println(userDTO1);
    }
}
