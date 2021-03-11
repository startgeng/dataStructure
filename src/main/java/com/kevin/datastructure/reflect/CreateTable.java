package com.kevin.datastructure.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  创建表名称
 * @author kevin
 * @version 1.0
 * @date 2021-03-08 9:44
 * @Describle 用来指定注解所对应类映射到数据库中的表名称
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateTable {

    String tableName();
}
