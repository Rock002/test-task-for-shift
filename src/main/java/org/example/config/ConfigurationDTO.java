package org.example.config;


import java.io.File;
import java.util.List;

public record ConfigurationDTO (
    boolean addToExisting,
    String pathToFiles,
    String fileNamePrefix,
    boolean isSimpleStats,
    boolean isFullStats,
    List<File> inputFiles
) { }
