package org.example.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<String> readFromAllFiles(List<File> inputFiles) {
        List<String> allLines = new ArrayList<>();

        for (File file : inputFiles) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                List<String> fileLines = bufferedReader.lines().toList();
                allLines.addAll(fileLines);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return allLines;
    }
}
