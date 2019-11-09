package com.yx.pub.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**数据需要传输
 * @author yx start
 * @create 2019/11/9,12:25
 */
@Data
@NoArgsConstructor
public class UserDTO  implements Serializable {

    private static final long serialVersionUID = 212320228991314020L;

    private String userName;
    private int age;
    private int userId ;
}
