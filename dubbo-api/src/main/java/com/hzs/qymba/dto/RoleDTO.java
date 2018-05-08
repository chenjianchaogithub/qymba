package com.hzs.qymba.dto;

import com.core.regular.BaseRegular;
import com.core.validator.GrpAdd;
import com.core.validator.GrpMod;
import com.core.validator.UserClass;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@UserClass(groups={ GrpAdd.class, GrpMod.class } ,message=" error info ")
public class RoleDTO implements Serializable,BaseRegular{

    @JsonView({BaseList.class})
    private Long id;

    @JsonView({BaseList.class})
    private String grouping;

    @JsonView({BaseList.class})
    private String name;

    @JsonView({BaseList.class})
    private String code;

    @JsonView({BaseList.class})
    private String sign;

    @JsonView({BaseList.class})
    private String description;

    @JsonView({BaseList.class})
    private Integer state;

    private Long stid;

    private Integer type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping == null ? null : grouping.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getStid() {
        return stid;
    }

    public void setStid(Long stid) {
        this.stid = stid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
