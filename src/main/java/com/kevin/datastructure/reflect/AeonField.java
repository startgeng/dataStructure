package com.kevin.datastructure.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-03-08 9:47
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AeonField {

    //名称
    String ColumnName();

    //类型
    String ColumnType();

    //长度
    int ColumnLength();
}
