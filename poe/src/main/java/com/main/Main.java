package com.main;

import java.util.Scanner;

import com.main.StoredUser.*;
import com.main.RegLog.*;

public class Main {
    public static void PrintOptionMenu() {
        System.out.println("1) Register a New user.");
        System.out.println("2) Login to existing user.");
        System.out.println("3) Exit app.");
    }

    public static void PrintMainMenu() {
        System.out.println("1) Send a new message.");
        System.out.println("2) View previous messages.");
        System.out.println("3) Exit app.");
    }

    public static StoredUser.User PrintRegistorMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("What is your full name?\n:");
        String FullName = in.nextLine();

        System.out.println("What is your username? \n:");
        String Username = in.nextLine();

        System.out.println("Enter your South African Phone number? \n:");
        String Phonenumber = in.nextLine();

        System.out.println("Enter your Email? \n:");
        String Email = in.nextLine();

        System.out.println("Enter your Password \n:");
        String Password = in.nextLine();

        return new User(new RegLog.Registration(FullName, Phonenumber, Email, Username, Password));
    }

    public static boolean CanLogin(StoredUser.User user) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Username:");
        String username = in.nextLine();

        System.out.println("Enter Password:");
        String password = in.nextLine();

        boolean isCorrectUserName = username.equals(user.UserName);
        boolean isCorrectUserPass = password.equals(user.Password);

        if (isCorrectUserName && isCorrectUserPass) {
            System.out.println("Welcome back " + user.UserName + ".");
            return true;
        } else {
            System.out.println("Either username or password is incorrect.");
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean isRunning = true;
        StoredUser.User TestUser = new User(
                new RegLog.Registration("Human Person", "+27111111111", "example@gmail.com", "Bot_", "I'mABot2"));

        while (isRunning) {
            PrintOptionMenu();

            boolean LoggedIn = false;

            String UserOption = in.next();

            StoredUser.User MainUser = null;

            if (UserOption.equals("1")) {
                MainUser = PrintRegistorMenu();
            } else if (UserOption.equals("2")) {
                LoggedIn = CanLogin(MainUser);
            }

            while (isRunning) {
                PrintOptionMenu();
                String UserSubOption = in.next();

                if (UserSubOption.equals("1")) {
                    MainUser = PrintRegistorMenu();
                } else if (UserOption.equals("2")) {
                    if (MainUser == null) {
                        System.out.println("No user registered yet.");
                    } else {
                        boolean loggedIn = CanLogin(MainUser);
                        if (loggedIn) {
                            System.out.println("Login successful.");
                        }
                    }
                } else if (UserOption.equals("3")) {
                    isRunning = false;
                }

            }

            in.close();
        }
    }
}