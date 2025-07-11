package org.example.sem3.task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToDo implements Externalizable {

    //region Поля
    /**
     * Наименование задачи
     */
    private String title;

    /**
     * Статус задачи
     */
    private boolean isDone;

    private transient String name;
    //endregion

    //region Конструкторы
    public ToDo() { }

    public ToDo(String title, String name) {
        this.title = title;
        this.name = name;
        isDone = false;
    }
    //endregion

    //region Externalizable implementation

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        isDone = in.readBoolean();
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

    public void setDone(boolean flag) {
        isDone = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion


}
