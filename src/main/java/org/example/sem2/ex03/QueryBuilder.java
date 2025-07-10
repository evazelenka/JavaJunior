package org.example.sem2.ex03;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilder {
    public String buildInsertQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");

        if (clazz.isAnnotationPresent(Table.class)){
            Table table = clazz.getAnnotation(Table.class);
            query.append(table.name())
                    .append(" (");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields){
                if (field.isAnnotationPresent(Column.class)){
                    Column column = field.getAnnotation(Column.class);
                    query.append(column.name())
                            .append(", ");
                }
            }
            if (query.charAt(query.length() -2) == ','){
                query.delete(query.length() - 2, query.length());
            }

            query.append(") VALUES (");

            for (Field field : fields) {
                if (field.isAnnotationPresent((Column.class))){
                    field.setAccessible(true);
                    query.append("'").append(field.get(obj)).append("', ");
                }
            }
            if (query.charAt(query.length() -2) == ','){
                query.delete(query.length() - 2, query.length());
            }
            query.append(");");
            return query.toString();
        }else {
            return null;
        }
    }

    public String buildSelectQuery(Class<?> clazz, UUID primaryKey){
        StringBuilder query = new StringBuilder("SELECT * FROM ");

        if (clazz.isAnnotationPresent(Table.class)){
            Table table = clazz.getAnnotation(Table.class);
            query.append(table.name()).append(" WHERE ");
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(Column.class)){
                Column column = field.getAnnotation(Column.class);
                if(column.primaryKey()){
                    query.append(field.getName()).append(" = ").append(primaryKey).append(";");
                    return query.toString();
                }
            }
        }
       return null;
    }

    public String buildUpdateQuery(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder query = new StringBuilder("UPDATE ");

        if (clazz.isAnnotationPresent(Table.class)){
            Table table = clazz.getAnnotation(Table.class);
            query
                    .append(table.name())
                    .append(" SET ");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields){
                if (field.isAnnotationPresent(Column.class)){
                    field.setAccessible(true);
                    Column column = field.getAnnotation(Column.class);
                    if(!column.primaryKey()){
                        field.setAccessible(true);
                        query.append(column.name()).append(" = '")
                                .append(field.get(obj)).append("', ");
                    }

                }
            }
            if (query.charAt(query.length() -2) == ','){
                query.delete(query.length() - 2, query.length());
            }

            query.append(" WHERE ");

            for (Field field : fields){
                if (field.isAnnotationPresent(Column.class)){
                    Column column = field.getAnnotation(Column.class);
                    if(column.primaryKey()){
                        field.setAccessible(true);
                        query.append(field.getName()).append(" = ").append(field.get(obj)).append(";");
                        break;
                    }
                }
            }
            query.append(");");
            return query.toString();
        }else
            return null;
    }


    /**
     * TODO: Доработать в рамках домашней работы!
     *
     * @param clazz
     * @param primaryKey
     * @return String
     */
    public String buildDeleteQuery(Class<?> clazz, UUID primaryKey){
        StringBuilder query = new StringBuilder("DELETE FROM ");

        if (clazz.isAnnotationPresent(Table.class)){
            Table table = clazz.getAnnotation(Table.class);
            query.append(table.name()).append(" WHERE ");
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(Column.class)){
                Column column = field.getAnnotation(Column.class);
                if(column.primaryKey()){
                    query.append(field.getName()).append(" = ").append(primaryKey).append(";");
                    return query.toString();
                }
            }
        }
        return null;
    }
}
