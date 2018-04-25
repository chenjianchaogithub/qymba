package com.hzs.qymba.api;


import com.hzs.qymba.dto.AmibaDTO;
import com.hzs.qymba.dto.DeptDTO;

import java.util.List;

public interface AmibaApi {

    /**
     * 查询所有
     * @return
     */
    List<AmibaDTO> selectAll();



}
