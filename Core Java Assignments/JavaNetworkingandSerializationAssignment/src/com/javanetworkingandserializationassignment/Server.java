package com.javanetworkingandserializationassignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            OperationData data = (OperationData) in.readObject();
            int result = calculate(data.num1, data.num2, data.operator);

            out.writeObject(result);

            in.close();
            out.close();
            clientSocket.close();
        }
     
    }

    private static int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2; // No divide by zero check for simplicity
            default: return 0; // Or throw an exception
        }
    }
}

