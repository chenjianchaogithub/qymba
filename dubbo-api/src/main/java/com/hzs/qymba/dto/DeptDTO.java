package com.hzs.qymba.dto;

import com.util.TreeEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DeptDTO implements TreeEntity<DeptDTO>,Serializable {
    private Long id;

    private Long parentid;

    private Long companyid;

    private String name;

    private Integer state;

    private Date adddate;

    private String remark;

    private Long stid;

    public List<DeptDTO> childList;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getStid() {
        return stid;
    }

    public void setStid(Long stid) {
        this.stid = stid;
    }

    public List<DeptDTO> getChildList() {
        return childList;
    }

    @Override
    public void setChildList(List<DeptDTO> childList) {
        this.childList = childList;
    }
}