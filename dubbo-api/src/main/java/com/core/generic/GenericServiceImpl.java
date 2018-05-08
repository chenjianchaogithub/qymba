package com.core.generic;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

public class GenericServiceImpl<M extends GenericMapper<T>, T> extends ServiceImpl<M,T> implements GenericService<T> {

}
