package com.hzs.qymba.dto;

import java.io.Serializable;
import java.util.Date;

import com.core.regular.BaseRegular;
import com.core.validator.GrpAdd;
import com.core.validator.GrpMod;
import com.core.validator.UserClass;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@UserClass(groups={ GrpAdd.class, GrpMod.class } ,message=" error info ")
public class UserDTO implements Serializable,BaseRegular{

    @JsonView({BaseList.class})
    private Long id;

    @JsonView({BaseList.class})
    private String name;

    @JsonView({BaseList.class})
    private String username;

    private String password;

    private Integer state;

    @JsonView({BaseList.class})
    private String creattime;

    @JsonView({BaseList.class})
    private String mob;

    @JsonView({BaseList.class})
    private Integer usertype;

    private Long deptid;

    private String dept;

    private String openid;

    private Long stid;

    @JsonView({BaseList.class})
    private String email;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob == null ? null : mob.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Long getDeptid() {
        return deptid;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Long getStid() {
        return stid;
    }

    public void setStid(Long stid) {
        this.stid = stid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}
