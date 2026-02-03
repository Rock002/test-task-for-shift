package org.example.sorter;

import org.example.dto.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class SortByType {
    private static final Logger LOGGER = LoggerFactory.getLogger(SortByType.class);

    public static EnumMap<Type, List<?>> apply(List<String> allLines) {
        EnumMap<Type, List<?>> sortedLines = new EnumMap<>(Type.class);

        List<Long> longList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        for (String line : allLines) {
            try {
                long longNumber =  Long.parseLong(line);
                longList.add(longNumber);
                continue;
            } catch (NumberFormatException _) { }

            try {
                double doubleNumber = Double.parseDouble(line);
                doubleList.add(doubleNumber);
                continue;
            } catch (NumberFormatException _) { }

            stringList.add(line);
        }

        sortedLines.put(Type.INTEGER, longList);
        sortedLines.put(Type.FLOAT, doubleList);
        sortedLines.put(Type.STRING, stringList);

        LOGGER.info("Сортровка данных завершена");

        return sortedLines;
    }
}
