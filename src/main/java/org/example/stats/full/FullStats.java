package org.example.stats.full;

import org.example.dto.Type;

import java.util.List;

public interface FullStats {
    void apply(List<?> sortedLines, Type type);
}
