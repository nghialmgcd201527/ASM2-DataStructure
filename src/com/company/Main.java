package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Messager message1 = new Messager("Message 1");
        Messager message2 = new Messager("Message 2");

        long start = System.currentTimeMillis();
        try {
            message1.connect(message2);
            System.out.println("Enter multiple sentences (enter an empty string to exit):");
            while (true) {
                String sentence = scanner.nextLine();
                if (sentence.isEmpty())
                    break;
                message1.send(sentence);
            }

            message2.receive();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        scanner.close();

        long elapsedTimeMillis = System.currentTimeMillis() - start;
        message2.printAll();
        System.out.print("Time executed: ");
        System.out.println(elapsedTimeMillis / 100000.0);
    }
}
