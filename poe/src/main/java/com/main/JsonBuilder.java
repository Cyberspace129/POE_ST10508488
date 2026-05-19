package com.main;

import java.io.FileWriter;
import java.io.IOException;

public class JsonBuilder {

  // Builds ONE message block
  public static String buildMessageBlock(Message msg) {

    String index = String.format("%02d", msg.getNumberMessage());

    return "        {\n" +
        "            \"Message_" + index + "\": {\n" +
        "                \"Message_ID\": \"" + msg.getMessageID() + "\",\n" +
        "                \"Message_Hash\": \"" + msg.getMessageHash() + "\",\n" +
        "                \"Message_Sender\": \"" + msg.getOtherNumber() + "\",\n" +
        "                \"Message_Resever\": \"" + msg.getOtherNumber() + "\",\n" +
        "                \"Message\": \"" + msg.getMessageSending() + "\"\n" +
        "            }\n" +
        "        }";
  }

  // Builds full JSON from StoreData (no lists used)
  public static String buildFullJson(StoreData data) {

    String json = "{\n    \"Messages\": [\n";

    int size = data.size();

    for (int i = 0; i < size; i++) {

      Message msg = data.get(i);

      json += buildMessageBlock(msg);

      if (i < size - 1) {
        json += ",\n";
      } else {
        json += "\n";
      }
    }

    json += "    ]\n}";

    return json;
  }

  // Writes JSON to file
  public static void writeToFile(String json, String filePath) {

    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write(json);
      writer.flush();
    } catch (IOException e) {
      System.out.println("Failed to write JSON file: " + e.getMessage());
    }
  }

  // Convenience method: build + write in one call
  public static void export(StoreData data, String filePath) {
    String json = buildFullJson(data);
    writeToFile(json, filePath);
  }
}