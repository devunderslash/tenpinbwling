package com.bowling.play.Exporter;

import com.bowling.play.Model.Frame;

import java.util.List;
import java.util.Map;

public interface OutputService {
    String buildBoard(Map<String, List<Frame>> playsMap);
    void printBoard(Map<String, List<Frame>> playsMap);
}
