package com.main;

import java.util.Scanner;

import com.main.StoredUser;
import com.main.RegLog;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StoredUser.User User;

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("What is your username? \n:");
            String Username = in.nextLine();
            System.out.println("Enter your South African Phone number? \n:");
            String Phonenumber = in.nextLine();
            System.out.println("");
            String Email = Email;
            String Password = Password;

            // has no data
            User = StoredUser.User();
        }

        in.close();
    }
}
