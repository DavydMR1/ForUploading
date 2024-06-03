package homework.calculator.dao.impl;

import homework.calculator.dao.Operation;

import java.io.FileWriter;
import java.io.IOException;

public class FileOperation implements Operation {
    private final String fileName;

    public FileOperation(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void saveLog(String data) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(data);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}