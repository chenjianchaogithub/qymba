package com.hzs.qymba.mapper;

import com.hzs.qymba.model.CustomContacts;
import com.util.ParamMap;

import java.util.List;

public interface CustomContactsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomContacts record);

    int insertSelective(CustomContacts record);

    CustomContacts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomContacts record);

    int updateByPrimaryKey(CustomContacts record);

    /**
     * 查询所有用户列表
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
     * 查询单个用户
     * @param id
     * @return
     */
    CustomContacts selectByCustomContactsId(Long id);
}