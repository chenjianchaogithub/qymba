package com.hzs.qymba.dto;

import com.core.regular.BaseRegular;
import com.core.validator.GrpAdd;
import com.core.validator.GrpMod;
import com.core.validator.UserClass;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@UserClass(groups={ GrpAdd.class, GrpMod.class } ,message=" error info ")
public class CustomDTO implements Serializable,BaseRegular{
    private Long id;

    private String customname;

    private String customabb;

    private String saletypename;

    private String address;

    private String phone;

    private String email;

    private String remark;

    private Integer depttype;

    private Long deptid;

    private Integer state;

    private Boolean isdel;

    private Date adddate;

    private Long createid;

    private String createname;

    private Date editdate;

    private Long editid;

    private String editname;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname == null ? null : customname.trim();
    }

    public String getCustomabb() {
        return customabb;
    }

    public void setCustomabb(String customabb) {
        this.customabb = customabb == null ? null : customabb.trim();
    }

    public String getSaletypename() {
        return saletypename;
    }

    public void setSaletypename(String saletypename) {
        this.saletypename = saletypename == null ? null : saletypename.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDepttype() {
        return depttype;
    }

    public void setDepttype(Integer depttype) {
        this.depttype = depttype;
    }

    public Long getDeptid() {
        return deptid;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public Long getCreateid() {
        return createid;
    }

    public void setCreateid(Long createid) {
        this.createid = createid;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public Long getEditid() {
        return editid;
    }

    public void setEditid(Long editid) {
        this.editid = editid;
    }

    public String getEditname() {
        return editname;
    }

    public void setEditname(String editname) {
        this.editname = editname == null ? null : editname.trim();
    }
}
