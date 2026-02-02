package org.example.dto;


import java.io.File;
import java.util.EnumMap;
import java.util.List;

public record ConfigurationDTO (
    EnumMap<Type, String> pathsToOutputFiles,
    boolean addToExisting,
    boolean isSimpleStats,
    boolean isFullStats,
    List<File> inputFiles
) { }
