package com.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class ReadingJson {

    public static void main(String[] args) throws JsonParseException, IOException {

        JsonFactory factory = new JsonFactory();

        File file = new File("Post.json");

        JsonParser parser = factory.createParser(file);

        JsonToken token = parser.nextToken();

        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName()))
            ;

        token = parser.nextToken();
        if (token == JsonToken.VALUE_STRING) {
            System.out.println("ID  : " + parser.getText());
        }

        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME && "tags".equals(parser.getCurrentName()))

            System.out.println("Post tags are - ");
        token = parser.nextToken();

        while (token != JsonToken.END_ARRAY)

        {
            token = parser.nextToken();

            if (token == JsonToken.VALUE_STRING) {
                System.out.println(parser.getText());
            }
        }
        System.out.println();
    }
}
