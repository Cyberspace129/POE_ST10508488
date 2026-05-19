package com.main;

import java.io.File;    
import java.io.FileWriter;
import java.io.IOException;
import com.main.Message;

public class Json {

  public static void MakeJsonFIle(String NameFile) {
    try {
      File myfile = new File(NameFile);
      if (!myfile.createNewFile()) {
        System.out.println("File already Created" + myfile.getName());
      }  
    } catch (IOException e) {
      System.out.println("An error occured");
      e.printStackTrace();
    }
  }
  
  public static void WriteToJson(File FileName, Message message){
    private final long messageID = message.messageID;
    private final int numberMessage = message.numberMessage;
    private final String otherNumber = message.otherNumber;
    private final String messageSending = message.messageSending;
    private final String messageHash = message.messageHash;
    
    FileName.write("{\n");
    FileName.write("\tMessage"+numberMessage+" : {\n");
    FileName.write("\t\"Message_ID\": "+Message_ID+",\n");
    FileName.write("\t\"Message_Hash\": "+Message_Hash+",\n");
    FileName.write("\t\"Message_Sender\": "+message.Message_Sender+",\n");
    FileName.write("\t\"Message_Resever\": "+message.Message_Resever+",\n");
    FileName.write("\t\"Message\": "+Message+"\n");
  }
  
  
}
