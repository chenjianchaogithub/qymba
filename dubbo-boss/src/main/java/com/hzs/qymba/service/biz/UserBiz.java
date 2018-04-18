package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.google.gson.Gson;
import com.hzs.qymba.api.UserApi;
import com.hzs.qymba.dto.UserDTO;
import com.hzs.qymba.model.User;
import com.hzs.qymba.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBiz implements UserApi {

    private Logger logger = LoggerFactory.getLogger(UserBiz.class);

    @Autowired
    private UserService userService;

    /**
     * 身份验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    public UserDTO authentication(AuthenticationToken token) throws AuthenticationException {
        User user = userService.authentication(token);
        UserDTO userDTO = new UserDTO();
        if (user!=null) {
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
        }else{
            userDTO = null;
        }
        return userDTO;
    }

    @Override
    public List<UserDTO> selectAll() {
        List<User> userList = userService.selectAll();
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        Gson gs = new Gson();
        for (User user:userList){
            String userStr = gs.toJson(user);
            UserDTO userDTO = gs.fromJson(userStr,UserDTO.class);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
