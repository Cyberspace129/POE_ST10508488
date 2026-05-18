package com.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import com.main.Message;

public class Json {
    class root {
        public Message Message;
    }

    public void saveJson(root data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("message.json"), data);
    }
}
