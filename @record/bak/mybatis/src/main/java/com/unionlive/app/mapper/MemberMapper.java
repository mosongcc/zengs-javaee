package com.unionlive.app.mapper;

import com.unionlive.app.entity.ZeMember;
import com.unionlive.app.entity.ZeMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {

    ZeMember getMember(int id);

    long countByExample(ZeMemberExample example);

    int deleteByExample(ZeMemberExample example);

    int insert(ZeMember record);

    int insertSelective(ZeMember record);

    List<ZeMember> selectByExample(ZeMemberExample example);

    int updateByExampleSelective(@Param("record") ZeMember record, @Param("example") ZeMemberExample example);

    int updateByExample(@Param("record") ZeMember record, @Param("example") ZeMemberExample example);



}
