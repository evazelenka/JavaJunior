package org.example.sem4.models;

public interface StudentsRepository extends Repository<Student, Integer>{
    // region характерные сущности методы
    Integer getGPA(int id);
    // endregion
}
