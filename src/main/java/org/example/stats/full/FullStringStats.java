package org.example.stats.full;

import org.example.dto.Type;

import java.util.List;

public class FullStringStats implements FullStats {
    @Override
    public void apply(List<?> inputLines, Type type) {
        if (inputLines.isEmpty()) {
            output(null, null, type);
            return;
        }

        List<String> lines = (List<String>) inputLines;
        int minStringSize = Integer.MAX_VALUE;
        int maxStringSize = Integer.MIN_VALUE;

        for (String line : lines) {
            if (line.length() > maxStringSize) {
                maxStringSize = line.length();
            }

            if (line.length() < minStringSize) {
                minStringSize = line.length();
            }
        }

        output(minStringSize, maxStringSize, type);
    }

    public void output(Integer minStringSize, Integer maxStringSize, Type type) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(type.name()).append(":").append('\n')
                .append("-".repeat(25)).append('\n')
                .append("  min size  : ").append(minStringSize).append('\n')
                .append("  max size  : ").append(maxStringSize).append('\n')
                .append("-".repeat(25)).append('\n');

        System.out.println(stringBuilder);
    }
}
