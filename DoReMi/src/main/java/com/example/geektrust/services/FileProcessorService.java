package com.example.geektrust.services;

import com.example.geektrust.exception.CustomExceptionHandler;
import com.example.geektrust.model.Arguments;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vishal Malviya
 */
@RequiredArgsConstructor
public class FileProcessorService {
    @NonNull
    private String filePath;

    public List<Arguments> getCommandsFromFile() throws CustomExceptionHandler {
        try (Stream<String> lines = Files.lines(Paths.get(this.filePath))) {
            return lines
                    .filter(line -> !isEmptyOrComment(line))
                    .map(Arguments::from)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new CustomExceptionHandler("error occurred while processing input file at " + filePath);
        }
    }

    private boolean isEmptyOrComment(String line) {
        return Strings.isEmpty(line) || line.trim().isEmpty() || line.trim().startsWith("#");
    }
}