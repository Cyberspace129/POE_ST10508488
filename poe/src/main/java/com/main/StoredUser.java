package com.main;

public class StoredUser {

    public static class Message {
        int MessageID; // Number that is 10 long
        int NumberMessage; // Number index of the message
        String OtherNumebr; // recipients number
        String MessageSending; // the message im send
        String MessageHash; // code of the message

        Message(int MessageID_, int NumberMessage_, String OtherNumebr_, String MessageSending_, String MessageHash_) {
            MessageID = MessageID_;
            NumberMessage = NumberMessage_;
            OtherNumebr = OtherNumebr_;
            MessageSending = MessageSending_;
            MessageHash = MessageHash_;
        }
    }

    public static class User {
        String UserName;
        String Email;
        String PhoneNumber;
        String Password;

        User(String UserName_, String Email_, String PhoneNumber_, String Password_) {
            UserName = UserName_;
            Email = Email_;
            PhoneNumber = PhoneNumber_;
            Password = Password_;
        }
    }
}
