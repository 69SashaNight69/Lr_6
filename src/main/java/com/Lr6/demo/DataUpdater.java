package com.Lr6.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DataUpdater {

    @Value("${file.path}")
    private String filePath;
    private int counter = 0;

    @Scheduled(fixedRate = 10000) // Запускається кожні 10 секунд
    public void updateData() {
        counter += 5;
        writeToFile(String.valueOf(counter));
        System.out.println("Counter updated: " + counter);
    }

    private void writeToFile(String data) {
        Path file = Paths.get(filePath);
        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile(), true));
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}