package org.example.lec5;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientExample2 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket client = new Socket(address, 1300);

            System.out.println(client.getInetAddress());
            System.out.println(client.getOutputStream());

            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            PrintStream printStream = new PrintStream(outputStream);

            printStream.println("hi!");
            System.out.println(dataInputStream.readLine());
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}