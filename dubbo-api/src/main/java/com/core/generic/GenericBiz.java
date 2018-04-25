package com.core.generic;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class GenericBiz<T,T1> {

    /**
     * 类型转换
     * @param list
     * @return
     */
    public List<T> gsonList(List<T1> list){
        List<T> dtoList = new ArrayList<T>();
        Gson gs = new Gson();
        for ( T1 t1:list){
            String str = gs.toJson(t1);
            T t = (T)gs.fromJson(str, Object.class);
            dtoList.add(t);
        }
        return dtoList;
    }

    public T gsonObject(T1 t1){
        Gson gs = new Gson();
        String str = gs.toJson(t1);
        T t = (T)gs.fromJson(str,Object.class);
        return t;
    }
}
