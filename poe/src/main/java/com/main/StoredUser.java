package com.main;

import com.main.RegLog;

public class StoredUser {

    public static class User {
        String FullName;
        String UserName;
        String Email;
        String PhoneNumber;
        String Password;

        User(RegLog.Registration UserInformation) {
            FullName = UserInformation.FullName;
            UserName = UserInformation.Username;
            Email = UserInformation.Email;
            PhoneNumber = UserInformation.Phonenumber;
            Password = UserInformation.Password;
        }
    }
}