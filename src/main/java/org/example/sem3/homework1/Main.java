package org.example.sem3.homework1;

import java.io.*;

/**
 * Задание 1:
 * Разработайте класс Student с полями String name, int age,
 * transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализируйте этот объект в файл.
 * Десериализируйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и обсудите почему значение GPA не было сохранено/восстановлено.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Dima", 26, 4.3);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.bin"))){
            oos.writeObject(student);
            System.out.println("Объект сериализован.");
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.bin"))){
            student = (Student) ois.readObject();
            System.out.println("Объект десериализован.");
            System.out.println(student);
        }
    }
}
