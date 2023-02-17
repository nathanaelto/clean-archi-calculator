package org.example.infra.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileParser {
    public static List<Integer> parse(String filePath) {
        return new FileParser().parseFile(filePath);
    }

    public List<Integer> parseFile(String filePath) {
        List<String> lines = this.readFile(filePath);
        return this.parseLines(lines);
    }

    public List<String> readFile(String filePath) {
        Path path = Path.of(filePath);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }
    }

    public List<Integer> parseLines(List<String> lines) {
        return lines.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
