package org.example.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);

    public static List<String> readFromAllFiles(List<File> inputFiles) {
        List<String> allLines = new ArrayList<>();

        for (File file : inputFiles) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                List<String> fileLines = bufferedReader.lines().toList();
                allLines.addAll(fileLines);
            } catch (FileNotFoundException exception) {
                LOGGER.error(exception.getMessage());
                throw new RuntimeException(exception);
            } catch (IOException e) {
                LOGGER.error("Ошибка чтения входного файла {}", file.getName());
                throw new RuntimeException(e);
            }
        }

        LOGGER.info("Чтение файлов завершено");

        return allLines;
    }
}
