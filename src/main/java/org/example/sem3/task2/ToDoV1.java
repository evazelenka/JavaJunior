package org.example.sem3.task2;

import java.io.Serializable;

// Не используется
public class ToDoV1 implements Serializable {
    //region Поля
    /**
     * Наименование задачи
     */
    private String title;

    /**
     * Статус задачи
     */
    private boolean isDone;
    //endregion

    //region Конструкторы
    public ToDoV1() { }

    public ToDoV1(String title) {
        this.title = title;
        isDone = false;
    }
    //endregion

    //region Методы
    /**
     * Получить наименование задачи
     * @return наименование задачи
     */
    public String getTitle() { return title; }

    /**
     * Получить статус выполнения задачи
     * @return статус выполнения задачи
     */
    public boolean isDone() {
        return isDone;
    }

    //endregion
}
