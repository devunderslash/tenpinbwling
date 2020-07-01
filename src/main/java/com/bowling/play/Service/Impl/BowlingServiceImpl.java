package com.bowling.play.Service.Impl;

import com.bowling.play.Model.Frame;
import com.bowling.play.Service.BowlingService;
import com.bowling.play.Utils.Helper;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BowlingServiceImpl implements BowlingService {

    @Override
    public Map<String, List<Frame>> calcPlayScoresFromMap(Map<String, List<Frame>> playsMap) {

        playsMap.forEach((name, values) -> {
            List<Frame> frames = calcPlayScoresFromList(values);
            playsMap.put(name, frames);
        });

        return playsMap;
    }

    private List<Frame> calcPlayScoresFromList(List<Frame> plays) {
        plays.forEach((play) -> {
            int total;
            if (play.isStrike()) {
                total = calcStrikeScore(play.getBall(), plays);
            } else if (play.isSpare()) {
                total = calcSpareScore(play.getBall(), plays);
            } else {
                total = calcNormalScore(play.getBall(), plays);
            }
            play.setTotalScore(String.valueOf(total));
        });


        return plays;
    }

    private int calcStrikeScore(int round, List<Frame> frames) {
        int total = 10;
        int index = round - 1;
        int previousPlayScore = index != 0 ? Helper.getIntegerValue(frames.get(index - 1).getTotalScore()) : 0;
        if (round < frames.size()) {
            Frame nextFrame = frames.get(index + 1);

            if (nextFrame.isStrike()) {
                Frame nextNextFrame = frames.get(index + 2);
                total += previousPlayScore + Helper.getIntegerValue(nextFrame.getFirstBallScore()) + Helper.getIntegerValue(nextNextFrame.getFirstBallScore());
            } else {
                total += previousPlayScore + Helper.getIntegerValue(nextFrame.getFirstBallScore()) + Helper.getIntegerValue(nextFrame.getSecondBallScore());
            }
        }
        return total;
    }

    private int calcSpareScore(int round, List<Frame> frames) {
        int total = 10;
        if (round < frames.size()) {
            int index = round - 1;
            int previousPlayScore = index != 0 ? Helper.getIntegerValue(frames.get(index - 1).getTotalScore()) : 0;
            Frame nextFrame = frames.get(index + 1);
            total += previousPlayScore + Helper.getIntegerValue(nextFrame.getFirstBallScore());
        }
        return total;
    }

    private int calcNormalScore(int round, List<Frame> frames) {
        int index = round - 1;
        int previousPlayScore = index != 0 ? Helper.getIntegerValue(frames.get(index - 1).getTotalScore()) : 0;
        Frame frame = frames.get(index);

        return Helper.getIntegerValue(frame.getFirstBallScore()) + Helper.getIntegerValue(frame.getSecondBallScore()) + Helper.getIntegerValue(frame.getFinalBallScore()) + previousPlayScore;
    }

    @Override
    public Map<String, List<Frame>> buildPlayListFromStream(Stream<String> lines) {

        return null;
    }
}
