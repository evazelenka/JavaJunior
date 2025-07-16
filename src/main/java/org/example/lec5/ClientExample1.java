package org.example.lec5;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientExample1 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket client = new Socket(address, 1300);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
