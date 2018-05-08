package com.hzs.qymba.service;

import com.hzs.qymba.model.CustomContacts;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomContactsService {

    /**
     * 查询所有用户
     * @return
     */
    List<CustomContacts> selectAll();

    /**
     * 带分页的分页计数查询
     * @param param
     * @return
     */
    long selectCount(ParamMap param);

    /**
     * 通过参数集，查询列表
     *
     * @param param
     * @return
     */
    List<CustomContacts> selectList(ParamMap param);

    /**
     * c
     * @param id
     * @return
     */
    CustomContacts selectByCustomContactsId(Long id);
}
