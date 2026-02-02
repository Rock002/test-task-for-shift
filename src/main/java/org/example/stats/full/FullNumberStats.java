package org.example.stats.full;

import org.example.dto.Type;

import java.util.List;

public class FullNumberStats implements FullStats {
    @Override
    public void apply(List<?> nums, Type type) {
        if (nums.isEmpty()) {
            output(null, null, null, null, type);
            return;
        }

        var numbers = type == Type.INTEGER ? (List<Long>) nums : (List<Double>) nums;

        double min = numbers.get(0).doubleValue();
        double max = numbers.get(0).doubleValue();
        double sum = 0;
        int count = 0;

        for (Number number : numbers) {
            if (number.doubleValue() < min) {
                min = number.doubleValue();
            }
            if (number.doubleValue() > max) {
                max = number.doubleValue();
            }
            sum += number.doubleValue();
            count++;
        }

        output(min, max, sum, count, type);
    }

    public void output(Double min, Double max, Double sum, Integer count, Type type) {
        Double average = sum == null ? null : sum / count;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(type.name()).append(":").append('\n')
                .append("-".repeat(25)).append('\n')
                .append("  min   : ").append(min).append('\n')
                .append("  max   : ").append(max).append('\n')
                .append("  sum   : ").append(sum).append('\n')
                .append("average : ").append(average).append('\n')
                .append("-".repeat(25)).append('\n');

        System.out.println(stringBuilder);
    }
}
