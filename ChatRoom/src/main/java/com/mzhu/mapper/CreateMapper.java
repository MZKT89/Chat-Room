package com.mzhu.mapper;

import org.apache.ibatis.annotations.Param;

public interface CreateMapper {

    int existTable(String tableName);

    int dropTable(@Param("tableName") String tableName);

    int createNewTable(@Param("tableName")String tableName);
}
