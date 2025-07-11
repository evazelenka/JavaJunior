package org.example.sem3.homework2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * Задание 2 (не обязательно):
 * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документов).
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Double g = 5.0;
        Student student = new Student("Dimak", 26, g);
        System.out.println(student);
        System.out.println();

        saveStudentToFile("student.json", student);
        saveStudentToFile("student.xml", student);
        student = getStudentFromFile("student.json");
        System.out.println("get student from student.json: " + student);
        student = getStudentFromFile("student.xml");
        System.out.println("get student from student.xml: " + student);
    }

    public static void saveStudentToFile(String fileName, Student student) throws IOException {
        if (fileName.endsWith(".json")){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(fileName), student);
        } else if (fileName.endsWith(".xml")){
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), student);
        } else System.out.println("this format of file is not allowed.");
    }

    public static Student getStudentFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        Student student = new Student();
        if (file.exists()){
            if (fileName.endsWith(".json")){
                ObjectMapper objectMapper = new ObjectMapper();
                student = objectMapper.readValue(file, objectMapper.getTypeFactory().constructType(Student.class));
                return student;
            } else if (fileName.endsWith(".xml")){
                XmlMapper xmlMapper = new XmlMapper();
                student = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructType(Student.class));
                return student;
            } else System.out.println("this format of file is not allowed.");
        }
        return null;
    }
}
