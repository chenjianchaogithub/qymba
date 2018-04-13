package com.hzs.qymba.model;

import java.io.Serializable;

public class Menu implements Serializable {
    private Long id;

    private String name;

    private String classname;

    private String icon;

    private String description;

    private String href;

    private String target;

    private String permissions;

    private Long parentid;

    private Integer orderid;

    private Integer state;

    private Boolean dialog;

    private Boolean curr;

    private String code;

    private Long stid;



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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions == null ? null : permissions.trim();
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getDialog() {
        return dialog;
    }

    public void setDialog(Boolean dialog) {
        this.dialog = dialog;
    }

    public Boolean getCurr() {
        return curr;
    }

    public void setCurr(Boolean curr) {
        this.curr = curr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getStid() {
        return stid;
    }

    public void setStid(Long stid) {
        this.stid = stid;
    }

/*    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }*/

    /**
     * 把菜单数据组织成一个树
     *
     * @param list
     */
/*    public Menu(List<Menu> list) {
        this.children = new ArrayList<Menu>();
        for (Menu item : list) {
            if (item.children != null)
                item.children.clear();
            if (!addToTree(item, this.children)) {
                this.children.add(item);
            }
        }
    }*/

    /*
     * 把结点放入树里
     */
/*    private boolean addToTree(Menu item, List<Menu> rs) {
        if (rs == null)
            return false;
        for (Menu menu : rs) {
            if (item.parentid.equals(menu.id)) {
                if (menu.children == null)
                    menu.children = new ArrayList<Menu>();
                menu.children.add(item);
                return true;
            }
            if (addToTree(item, menu.children))
                return true;
        }
        return false;
    }*/

}