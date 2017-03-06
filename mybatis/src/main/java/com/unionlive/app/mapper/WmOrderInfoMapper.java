package com.unionlive.app.mapper;

import com.unionlive.app.entity.WmOrderInfo;
import com.unionlive.app.entity.WmOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WmOrderInfoMapper {
    long countByExample(WmOrderInfoExample example);

    int deleteByExample(WmOrderInfoExample example);

    int insert(WmOrderInfo record);

    int insertSelective(WmOrderInfo record);

    List<WmOrderInfo> selectByExample(WmOrderInfoExample example);

    int updateByExampleSelective(@Param("record") WmOrderInfo record, @Param("example") WmOrderInfoExample example);

    int updateByExample(@Param("record") WmOrderInfo record, @Param("example") WmOrderInfoExample example);
}