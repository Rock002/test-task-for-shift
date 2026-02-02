package org.example.writer;

import org.example.dto.Type;
import picocli.CommandLine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;


public class Writer {
    public static void write(EnumMap<Type, List<?>> sortedLines, EnumMap<Type, String> pathsToOutputFiles) {
        for (Type type : Type.values()) {
            List<?> currentList = sortedLines.get(type);
            if (currentList.isEmpty()) {
                continue;
            }

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathsToOutputFiles.get(type)))) {
                currentList.forEach(
                        elem -> {
                            try {
                                bufferedWriter.write(elem.toString());
                                bufferedWriter.newLine();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
