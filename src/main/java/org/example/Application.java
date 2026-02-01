package org.example;

import org.example.config.ConfigurationDTO;
import picocli.CommandLine;
import picocli.CommandLine.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

@Command(name = "App")
public class Application implements Callable<Integer> {

    @Option(names = {"a"})
    boolean addToExisting;

    @Option(names = {"o"})
    String pathToFiles;

    @Option(names = {"p"})
    String fileNamePrefix;

    @Option(names = {"s"})
    boolean isSimpleStats;

    @Option(names = {"f"})
    boolean isFullStats;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Application()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        try {
            var config = validateAndGetConfiguration();

        } catch (RuntimeException exception) {
            return 1;
        }

        return 0;
    }

    public ConfigurationDTO validateAndGetConfiguration() {
        if (!Files.isDirectory(Path.of(pathToFiles))) {
            throw new RuntimeException();
        }

        return new ConfigurationDTO(
                addToExisting,
                pathToFiles,
                fileNamePrefix,
                isSimpleStats,
                isFullStats
        );
    }
}
