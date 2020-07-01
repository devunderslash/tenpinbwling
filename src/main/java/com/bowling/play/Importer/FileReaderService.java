package com.bowling.play.Importer;

import java.util.stream.Stream;

public interface FileReaderService {
    Stream<String> readFile(String file);
}
