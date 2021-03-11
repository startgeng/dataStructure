package com.kevin.datastructure.reflect;

import lombok.Data;

/**
 *  实体类
 * @author kevin
 * @version 1.0
 * @date 2021-03-08 9:48
 */
@CreateTable(tableName = "T_User")
@Data
public class T_User {

    @AeonField(ColumnName = "id",ColumnType = "int",ColumnLength = 10)
    private int id;

    @AeonField(ColumnName = "name",ColumnLength = 32,ColumnType = "VARCHAR")
    private String name;

    @AeonField(ColumnName = "age",ColumnLength = 2,ColumnType = "int")
    private int age;
}
