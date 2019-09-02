package com.example.demo.mapper;

import com.example.demo.entity.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

@Component
@Mapper
public interface InfoMapper extends BaseMapper<Info> {
    //用户查找
    @Select("select * from info where trim(username) = #{username}")
    Info findByUsername(@Param("username") String username);
    //用户数量统计
    Integer countByUsername(@Param("username") String username);

}