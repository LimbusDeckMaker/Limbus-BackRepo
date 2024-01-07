package com.example.demo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonNameChange{
    public static void main(String[] args) {
        String inputFilePath = "C:\\Spring\\demo\\src\\main\\java\\com\\example\\demo\\util\\SinclairData.json"; // Replace with your input file path
        String outputFilePath = "C:\\Spring\\demo\\src\\main\\java\\com\\example\\demo\\util\\SinclairDataChange_10.json"; // Replace with your output file path

        try {
            // Read JSON file
            String jsonString = new String(Files.readAllBytes(Paths.get(inputFilePath)), StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonString);

            // Process JSON data
            for (JsonNode egoNode : rootNode) {
                // Rename fields as required
                // ...

                // Example: Rename the first "name" to "ego_name"
                if (egoNode.has("name")) {
                    JsonNode nameNode = egoNode.get("name");
                    ((ObjectNode) egoNode).remove("name");
                    ((ObjectNode) egoNode).set("ego_name", nameNode);
                }

                JsonNode pass1Node = egoNode.path("sync3").path("pass1");
                if (!pass1Node.isMissingNode()) {
                    JsonNode pass1NameNode = pass1Node.get("name");
                    ((ObjectNode) pass1Node).remove("name");
                    ((ObjectNode) pass1Node).set("passive_name", pass1NameNode);
                }

                // Further processing...
            }

            // Write modified JSON to a new file
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFilePath), rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
