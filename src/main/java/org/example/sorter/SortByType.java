package org.example.sorter;

import org.example.dto.Type;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class SortByType {
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

        sortedLines.put(Type.LONG, longList);
        sortedLines.put(Type.DOUBLE, doubleList);
        sortedLines.put(Type.STRING, stringList);

        return sortedLines;
    }
}
