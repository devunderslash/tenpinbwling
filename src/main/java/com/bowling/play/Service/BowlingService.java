package com.bowling.play.Service;

import com.bowling.play.Model.Frame;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface BowlingService {

    Map<String, List<Frame>> calcPlayScoresFromMap(Map<String, List<Frame>> playsMap);
    Map<String, List<Frame>> buildPlayListFromStream(Stream<String> lines);
}
