package com.yx.pub.rpc;

import com.yx.pub.dto.UserDTO;

/**
 * Hello world!
 *
 */
@ServierMapped(mapperService = "com.yx.rpc.api.impl.UserServiceImpl" )
public interface UserService
{
   public UserDTO addUser(UserDTO userDTO);
}
