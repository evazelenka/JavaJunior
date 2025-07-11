package org.example.sem3.task1;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData user = new UserData("Eva", 25, "8545");

        try(FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(user);
            System.out.println("Объект UserData был сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("userdata.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            user = (UserData)objectInputStream.readObject();
            System.out.println("Объект UserData был десериализован.\n" + user.toString());
        }


        }
}
