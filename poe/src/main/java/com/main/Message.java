package com.main;

import java.util.Random;

public class Message {

    private static final Random rd = new Random();

    private final long messageID;
    private final int numberMessage;
    private final String otherNumber;
    private final String messageSending;
    private final String messageHash;

    public Message(int numberMessage_, String otherNumber_, String messageSending_) {
        messageID = generateID();
        numberMessage = numberMessage_;
        otherNumber = otherNumber_;
        messageSending = messageSending_;
        messageHash = generateHash(this).toUpperCase();
    }

    private static String generateHash(Message message) {
        String Short_ID = String.valueOf(message.messageID).substring(0, 2);
        return message.messageID + ":" + message.numberMessage + ":" + findFirstWord(message.messageSending)
                + findLastWord(message.messageSending);
    }

    private static long generateID() {
        return Math.abs(rd.nextLong() % 9_999_999_999L) + 1_000_000_000L;
    }

    private static String findFirstWord(String messageSending) {
        int index = messageSending.indexOf(" ");
        if (index == -1) {
            return messageSending;
        }
        return messageSending.substring(0, index);
    }

    private static String findLastWord(String messageSending) {
        int index = messageSending.lastIndexOf(" ");
        if (index == -1) {
            return messageSending;
        }
        return messageSending.substring(index);
    }

    public long getMessageID() {
        return messageID;
    }

    public int getNumberMessage() {
        return numberMessage;
    }

    public String getOtherNumber() {
        return otherNumber;
    }

    public String getMessageSending() {
        return messageSending;
    }

    public String getMessageHash() {
        return messageHash;
    }

}
