package com.hzs.qymba.dto;

import com.util.TreeEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CompanyDTO implements TreeEntity<CompanyDTO>,Serializable{
    private Long id;

    private Long parentid;

    private String name;

    private Integer isdel;

    private Date adddate;

    private Date editdate;

    private String remark;

    private Boolean isdobalance;

    private Boolean isdotax;

    private Float maxtaxrate;

    private Integer state;

    public List<CompanyDTO> childList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsdobalance() {
        return isdobalance;
    }

    public void setIsdobalance(Boolean isdobalance) {
        this.isdobalance = isdobalance;
    }

    public Boolean getIsdotax() {
        return isdotax;
    }

    public void setIsdotax(Boolean isdotax) {
        this.isdotax = isdotax;
    }

    public Float getMaxtaxrate() {
        return maxtaxrate;
    }

    public void setMaxtaxrate(Float maxtaxrate) {
        this.maxtaxrate = maxtaxrate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<CompanyDTO> getChildList() {
        return childList;
    }

    @Override
    public void setChildList(List<CompanyDTO> childList) {
        this.childList = childList;
    }
}
