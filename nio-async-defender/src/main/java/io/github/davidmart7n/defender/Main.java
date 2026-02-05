package io.github.davidmart7n.defender;

import io.github.davidmart7n.defender.writer.LogGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LogGenerator.generator("logEntries.log", 10000);

        
    }
}