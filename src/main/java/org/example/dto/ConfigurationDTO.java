package org.example.dto;


import java.io.File;
import java.util.EnumMap;
import java.util.List;

public record ConfigurationDTO (
    EnumMap<Type, String> pathsToOutputFiles,
    boolean isSimpleStats,
    boolean isFullStats,
    List<File> inputFiles
) { }
