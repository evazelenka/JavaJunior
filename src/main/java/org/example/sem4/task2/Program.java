package org.example.sem4.task2;

import org.example.sem4.models.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {
    /**
     * Задача 2
     * ========
     * <p>
     *     Настройте Hibernate, связав его с вашей базой
     *     данный.
     *     Создайте класс Student в Java, аннотируя его как
     *     сущность Hibernate.
     *     Используя Hibernate, реализуйте вставку, чтение,
     *     обновление и удаление данных в таблице.
     *     Обратите внимание на использование сессий и
     *     транзакций в Hibernate.
     * </p>
     */

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()){

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Student student = Student.create();
            session.save(student);
            System.out.println("Object student save successfully");

            Student retrievedStudent = session.get(Student.class, 57);
            System.out.println("Object student retrieved successfully");
            System.out.println("Retrieved student object: " + retrievedStudent);

            retrievedStudent.updateName();
            retrievedStudent.updateAge();
            session.update(retrievedStudent);
            System.out.println("Object student updated successfully");

            session.delete(retrievedStudent);
            System.out.println("Object student delete successfully");

            session.getTransaction().commit();

        }
        catch (HibernateException e) {
            e.printStackTrace();
        }


    }
}
