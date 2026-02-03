package org.example.writer;

import org.example.dto.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;


public class Writer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Writer.class);

    public static void write(EnumMap<Type, List<?>> sortedLines, EnumMap<Type, String> pathsToOutputFiles, boolean addToExisting) {
        for (Type type : Type.values()) {
            List<?> currentList = sortedLines.get(type);
            if (currentList.isEmpty()) {
                continue;
            }

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathsToOutputFiles.get(type), addToExisting))) {
                currentList.forEach(
                        elem -> {
                            try {
                                bufferedWriter.write(elem.toString());
                                bufferedWriter.newLine();
                            } catch (IOException e) {
                                LOGGER.error("Ошибка записи в файл {}", new File(pathsToOutputFiles.get(type)).getName());
                                throw new RuntimeException(e);
                            }
                        }
                );
            } catch (IOException e) {
                LOGGER.error("Ошибка открытия файла {}", new File(pathsToOutputFiles.get(type)).getName());
                throw new RuntimeException(e);
            }
        }

        LOGGER.info("Запись в файлы завершена");
    }
}
