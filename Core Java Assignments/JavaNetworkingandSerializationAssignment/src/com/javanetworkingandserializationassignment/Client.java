package com.javanetworkingandserializationassignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 12345);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter num1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter num2: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter operator: ");
        String operator = scanner.next();

        OperationData data = new OperationData(num1, num2, operator);
        out.writeObject(data);

        int result = (int) in.readObject();
        System.out.println("Result: " + result);

        in.close();
        out.close();
        socket.close();
        scanner.close();
    }
}
