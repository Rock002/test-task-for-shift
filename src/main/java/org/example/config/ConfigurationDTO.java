package org.example.config;


public record ConfigurationDTO (
    boolean addToExisting,
    String pathToFiles,
    String fileNamePrefix,
    boolean isSimpleStats,
    boolean isFullStats
) { }
