package org.example;

import org.example.config.ConfigurationDTO;
import org.example.reader.Reader;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Command(name = "App")
public class Application implements Runnable {

    @Option(names = {"-a"})
    boolean addToExisting;

    @Option(names = {"-o"})
    String pathToFiles;

    @Option(names = {"-p"})
    String fileNamePrefix;

    @Option(names = {"-s"})
    boolean isSimpleStats;

    @Option(names = {"-f"})
    boolean isFullStats;

    @Parameters
    List<File> inputFiles;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Application()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        ConfigurationDTO config;

        try {
            config = validateAndGetConfiguration();
        } catch (RuntimeException exception) {
            return;
        }

        List<String> allLines = Reader.readFromAllFiles(config.inputFiles());

    }

    public ConfigurationDTO validateAndGetConfiguration() throws RuntimeException {
        if (pathToFiles != null && !Files.isDirectory(Path.of(pathToFiles))) {
            throw new RuntimeException();
        }

        return new ConfigurationDTO(
                addToExisting,
                pathToFiles,
                fileNamePrefix,
                isSimpleStats,
                isFullStats,
                inputFiles
        );
    }
}
