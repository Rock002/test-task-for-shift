package org.example.stats.simple;

import org.example.dto.Type;

import java.util.EnumMap;
import java.util.List;

public class SimpleStats {
    public void apply(EnumMap<Type, List<?>> sortedLines) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("GENERAL:").append('\n');
        stringBuilder.append("-".repeat(25)).append('\n');

        for (Type type : Type.values()) {
            stringBuilder
                    .append("count of ")
                    .append(type.name())
                    .append(": ")
                    .append(sortedLines.get(type).size())
                    .append('\n');
        }

        stringBuilder.append("-".repeat(25)).append('\n');

        System.out.println(stringBuilder);
    }
}
