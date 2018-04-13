package com.util;

import java.util.List;

/**
 * 树形数据实体接口
 * @param <E>
 */
public interface TreeEntity<E> {
    public Long getId();
    public Long getParentid();
    public void setChildList(List<E> childList);
}
