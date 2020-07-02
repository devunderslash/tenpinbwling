package com.bowling.play.Importer.Impl;

import com.bowling.play.Importer.FileReaderService;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class FileReaderServiceImplTest extends TestCase {

    public void testReadFile() {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        Stream<String> plays = fileReaderService.readFile("RealGame.txt");
        List<String> playList = plays.collect(Collectors.toList());
        Assert.assertNotNull(plays);
        assertThat(playList, hasItems("John 3"));
    }
}
