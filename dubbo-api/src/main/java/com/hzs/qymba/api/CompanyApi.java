package com.hzs.qymba.api;

import com.hzs.qymba.dto.CompanyDTO;
import com.hzs.qymba.dto.UserDTO;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.List;
import java.util.Map;


public interface CompanyApi {

    /**
     * 查询所有
     * @return
     */
    List<CompanyDTO> selectAll();

    /**
     * 分页查询
     * @param param
     * @return
     */
    //Map<String, Object> selectPager(ParamMap param);

}
