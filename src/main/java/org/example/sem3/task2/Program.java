package org.example.sem3.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.sem3.task2.ToDoListApp.*;

/*
Задача:

Разработать приложение, аналог TODO лист.
Когда запускаем приложение, можем сами себе поставить ряд задач, а у каждой задачи будет состояние (выполнена/в работе) с возможностью отмечать статус.
Приложение можно закрывать -> все задачи со статусами сохраняются.
При новом открытии приложения -> все задачи затягиваются с момента предыдущего закрытия.
Сериализация не бинарная, чтобы можно было редактировать задачи без приложения.

 */
public class Program {

    public static void main(String[] args) {
        List<ToDo> tasks;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            tasks = loadTasksFromFile(FILE_JSON);
        else
            tasks = prepareTasks();
        saveTasksToFile(FILE_JSON, tasks);
        saveTasksToFile(FILE_BIN, tasks);
        saveTasksToFile(FILE_XML, tasks);

        displayTasks(tasks);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить новую задачу");
            System.out.println("2. Отметить задачу как выполненную");
            System.out.println("3. Выйти");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> ToDoListApp.addNewTask(scanner, tasks);
                case "2" -> ToDoListApp.markTaskAsDone(scanner, tasks);
                case "3" -> {
                    saveTasksToFile(FILE_JSON, tasks);
                    saveTasksToFile(FILE_BIN, tasks);
                    saveTasksToFile(FILE_XML, tasks);
                    System.out.println("Список задач сохранен.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
            displayTasks(tasks);
        }
    }

    static List<ToDo> prepareTasks() {
        ArrayList<ToDo> list = new ArrayList<>();
        list.add(new ToDo("Сходить в магазин за продуктами", "eva"));
        list.add(new ToDo("Погулять с собакой", "eva"));
        list.add(new ToDo("Заменить лампочку", "eva"));
        return list;
    }


}
