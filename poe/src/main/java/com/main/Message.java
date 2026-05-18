package com.main;

java.util.Random;

public class Message {

    public static class Message {
        
        Random rd = new Random();
        
        int MessageID;
        int NumberMessage;
        String OtherNumebr;
        String MessageSending;
        String MessageHash;
    
        Message(int NumberMessage_, String OtherNumebr_, String MessageSending_, ) {
            MessageID = GenerateID();
            NumberMessage = NumberMessage_;
            OtherNumebr = OtherNumebr_;
            MessageSending = MessageSending_;
            MessageHash = GenerateHash(MessageSending_);
        }
        
        public static String GenerateHash(Message Message){
            return MessageID.substring(0,1) + ":" + NumberMessage + ":" + FindFirstWord(MessageSending) + FindLastWord(MessageSending)
        }
        public static int GenerateID(){
            // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/random/package-summary.html
            return (rd.nextInt(8_999_999_999) + 1_000_000_000)
            
        }
        public static String FindFirstWord(Message Message){
            int Index = Message.MessageSending.indexof(" "); // https://www.w3schools.com/java/ref_string_indexof.asp
            return Message.MessageSending.substring(0,Index);
        }
        public static String FindLastWord(Message Message){
            int Index = Message.MessageSending.lastIndexof(" ");
            return Message.MessageSending.substring(Index,Message.MessageSending.length());
        }
    }
}
