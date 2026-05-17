package com.main;

import com.main.RegLog;

public class StoredUser {

    public static class Message {
        int MessageID;
        int NumberMessage;
        String OtherNumebr;
        String MessageSending;
        String MessageHash;

        Message(int MessageID_, int NumberMessage_, String OtherNumebr_, String MessageSending_, String MessageHash_) {
            MessageID = MessageID_;
            NumberMessage = NumberMessage_;
            OtherNumebr = OtherNumebr_;
            MessageSending = MessageSending_;
            MessageHash = MessageHash_;
        }
    }

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