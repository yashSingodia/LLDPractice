package DesignPatterns.StrategyPattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        PaymentStrategy paymentStrategy = new DebitCardStrategy();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(""));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
