package com.hzs.qymba.api;


import com.hzs.qymba.dto.DeptDTO;

import java.util.List;

public interface DeptApi {

    /**
     * 查询所有
     * @return
     */
    List<DeptDTO> selectAll();



}
