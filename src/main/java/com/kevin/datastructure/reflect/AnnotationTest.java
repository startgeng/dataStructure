package com.kevin.datastructure.reflect;

import lombok.extern.slf4j.Slf4j;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *  解析类获取sql语句
 * @author kevin
 * @version 1.0
 * @date 2021-03-08 9:52
 */
@Slf4j
public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = T_User.class;
        CreateTable annotation = clazz.getAnnotation(CreateTable.class);
        System.out.println("表名:"+annotation.tableName());

        Annotation[] annotations = clazz.getAnnotations();
        if (annotations != null){
            for (Annotation annotation1 : annotations) {
                System.out.println(annotation1);
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Create table ");
        builder.append(annotation.tableName()).append(" (");
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null){
            for (Field field : fields) {
                field.setAccessible(true);
                AeonField aeonField = field.getAnnotation(AeonField.class);
                builder.append(aeonField.ColumnName()+" ").append(aeonField.ColumnType() ).append("(").append(aeonField.ColumnLength()).append("),");
            }
        }
        String s = builder.substring(0, builder.lastIndexOf(",")) + ")";
        log.info(s);
    }
}
