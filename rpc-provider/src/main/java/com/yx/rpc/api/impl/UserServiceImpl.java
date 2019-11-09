package com.yx.rpc.api.impl;

import com.yx.pub.dto.UserDTO;
import com.yx.pub.rpc.UserService;

import java.util.Random;

/** 实现类处理的相关问题
 * @author yx start
 * @create 2019/11/9,13:08
 */
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        System.out.println("accept param :" +userDTO);
        userDTO.setUserId(new Random().nextInt(1000));
        System.out.println("return VO :" +userDTO);
        return userDTO;
    }
}
