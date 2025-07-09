package org.example.sem2.ex03;

import java.lang.reflect.Field;

public class QueryBuilder {
    public String buildInsertQuery(Object obj){
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");

        if (clazz.isAnnotationPresent(Table.class)){
            Table table = clazz.getAnnotation(Table.class);
            query.append(table.name())
                    .append(" (");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields){
                if (field.isAnnotationPresent(Column.class)){
                    Column column = clazz.getAnnotation(Column.class);
                    query.append(column.name())
                            .append(", ");
//                            .append(column.primaryKey());
                }
            }
            if (query.charAt(query.length() -2) == ','){
                query.delete(query.length() - 2, query.length() - 1);
            }

            query.append(") VALUES (");

            for (Field field : fields) {
                if (field.isAnnotationPresent((Column.class))){
                    Column column = field.getAnnotation(Column.class);
                    query.append(column.name()).append(", ");
                }
            }
        }else {
            return null;
        }
    }
}
