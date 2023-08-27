package com.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        JsonFactory factory = new JsonFactory();

        JsonGenerator generator = factory.createGenerator(new File("Post.json"), JsonEncoding.UTF8);

        generator.writeStartObject();
        // Add string field
        generator.writeNumberField("id", 100);
        generator.writeStringField("title", "Jackson JSON API Guide");
        generator.writeStringField("description", "Post about Jackson JSON API");
        generator.writeStringField("content", "HTML content Here");

        // creating Json Array within json Object
        generator.writeFieldName("tags");

        // Array of Tag objects

        generator.writeStartArray();

        generator.writeStartObject();
        generator.writeNumberField("id", 1);
        generator.writeStringField("name", "JSON");
        generator.writeEndObject();

        generator.writeStartObject();
        generator.writeNumberField("id", 2);
        generator.writeStringField("name", "Java");
        generator.writeEndObject();

        generator.writeStartObject();
        generator.writeNumberField("id", 3);
        generator.writeStringField("name", "Jackson");
        generator.writeEndObject();

        generator.writeEndArray(); // End with right bracket i.e. ]

        generator.writeEndObject(); // End with right brace i.e }

        // Close JSON generator
        generator.close();
    }
}
