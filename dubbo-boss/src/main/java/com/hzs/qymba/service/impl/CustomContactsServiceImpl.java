package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.CustomContactsMapper;
import com.hzs.qymba.model.CustomContacts;
import com.hzs.qymba.service.CustomContactsService;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomContactsServiceImpl implements CustomContactsService {
    @Resource
    private CustomContactsMapper customContactsMapper;


    public List<CustomContacts> selectAll(){
        return customContactsMapper.selectAll();
    }


    @Override
    public long selectCount(ParamMap param) {
        return customContactsMapper.selectCount(param);
    }

    @Override
    public List<CustomContacts> selectList(ParamMap param) {
        return customContactsMapper.selectList(param);
    }

    @Override
    public CustomContacts selectByCustomContactsId(Long id) {
        return customContactsMapper.selectByCustomContactsId(id);
    }
}
