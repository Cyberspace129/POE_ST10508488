package com.main;

public class StoreData {

    private Message[] data = new Message[1];
    private int size = 0;

    public void append(Message msg) {

        if (size == data.length) {
            grow();
        }

        data[size] = msg;
        size++;
    }

    public Message get(int index) {
        if (index < 0 || index >= size)
            return null;
        return data[index];
    }

    public int size() {
        return size;
    }

    private void grow() {

        Message[] newData = new Message[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}