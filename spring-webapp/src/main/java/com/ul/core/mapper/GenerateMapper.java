package com.ul.core.mapper;

import com.ul.app.member.entity.Member;

import java.util.List;

/**
 *
 */
public interface GenerateMapper<T> {


    int insert(T o);

    List<T> findAll();




}
