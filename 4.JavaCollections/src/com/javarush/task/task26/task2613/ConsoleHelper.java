package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String input = "";
        try {
            input = bis.readLine();
            if (input.equalsIgnoreCase(res.getString("operation.EXIT"))) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) {}

        return input;
    }

    public static String askCurrencyCode() throws InterruptOperationException {

        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String str = readString();
            if (str.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            } else {
                return str.toUpperCase();
            }
        }

    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        String[] input;
        while (true) {
            input = readString().split(" ");

            int nominal = 0;
            int total = 0;
            try {
                nominal = Integer.parseInt(input[0]);
                total = Integer.parseInt(input[1]);
            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (nominal <= 0 || total <= 0) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return input;
    }

    public static Operation askOperation() throws InterruptOperationException {
        do {
            writeMessage(res.getString("operation.INFO"));
            writeMessage(res.getString("operation.DEPOSIT"));
            writeMessage(res.getString("operation.WITHDRAW"));
            writeMessage(res.getString("operation.EXIT"));
            try {
                String input = readString();
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        } while (true);

    }

    public static void printExitMessage(){
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
