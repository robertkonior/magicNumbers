package app;

import app.validators.Validator;

import java.util.Scanner;

public class AppRunner {

    public static void main(String[] args) {
        System.out.println("enter file path to validate");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        Validator validator = new Validator(filePath);
        validator.isValid();
    }
}
