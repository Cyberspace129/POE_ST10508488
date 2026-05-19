package com.main;

import java.util.Scanner;

import com.main.StoredUser;
import com.main.RegLog;
import com.main.JsonBuilder;
import com.main.StoreData;

public class Main {

    public static void PrintOptionMenu() {
        System.out.println("1) Register a New user.");
        System.out.println("2) Login to existing user.");
        System.out.println("3) Exit app.");
    }

    public static void PrintMainMenu() {
        System.out.println("1) Send a new message.");
        System.out.println("2) View previous messages.");
        System.out.println("3) Logout.");
    }

    public static StoredUser.User PrintRegistorMenu(Scanner in) {

        System.out.println("What is your full name?");
        String FullName = in.nextLine();

        System.out.println("What is your username?");
        String Username = in.nextLine();

        System.out.println("Enter your South African Phone number?");
        String Phonenumber = in.nextLine();

        System.out.println("Enter your Email?");
        String Email = in.nextLine();

        System.out.println("Enter your Password");
        String Password = in.nextLine();

        return new StoredUser.User(
                new RegLog.Registration(FullName, Phonenumber, Email, Username, Password));
    }

    public static boolean CanLogin(StoredUser.User user, Scanner in) {

        if (user == null) {
            System.out.println("No user registered yet.");
            return false;
        }

        System.out.println("Enter Username:");
        String username = in.nextLine();

        System.out.println("Enter Password:");
        String password = in.nextLine();

        boolean okUser = username.equals(user.UserName);
        boolean okPass = password.equals(user.Password);

        if (okUser && okPass) {
            System.out.println("Welcome back " + user.UserName + ".");
            return true;
        } else {
            System.out.println("Either username or password is incorrect.");
            return false;
        }
    }

    public static void main(String[] args) {

        StoreData data = new StoreData();
        Scanner in = new Scanner(System.in);

        int MessageNumber = 0;
        boolean isRunning = true;

        StoredUser.User MainUser = null;

        while (isRunning) {

            PrintOptionMenu();
            String UserOption = in.nextLine();

            if (UserOption.equals("1")) {

                MainUser = PrintRegistorMenu(in);

            } else if (UserOption.equals("2")) {

                boolean loggedIn = CanLogin(MainUser, in);

                if (loggedIn) {

                    boolean loggedInMenu = true;

                    while (loggedInMenu) {

                        PrintMainMenu();
                        String UserSubOption = in.nextLine();

                        if (UserSubOption.equals("1")) {

                            System.out.println("Enter recipient number: ");
                            String number = in.nextLine();

                            System.out.println("Enter Message: ");
                            String messageText = in.nextLine();

                            Message message = new Message(MessageNumber, number, messageText);

                            data.append(message);

                            JsonBuilder.export(data, "messages.json");

                            MessageNumber++;
                        }

                        else if (UserSubOption.equals("2")) {

                            // Print stored messages from StoreData
                            for (int i = 0; i < data.size(); i++) {
                                Message msg = data.get(i);
                                System.out.println(JsonBuilder.buildMessageBlock(msg));
                            }
                        }

                        else if (UserSubOption.equals("3")) {
                            loggedInMenu = false;
                        }
                    }
                }

            } else if (UserOption.equals("3")) {
                isRunning = false;
            }
        }

        in.close();
    }
}