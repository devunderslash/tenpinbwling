package com.bowling.play.Validation.Impl;

import com.bowling.play.Model.Frame;
import com.bowling.play.Utils.Helper;
import com.bowling.play.Validation.BowlingValidation;

import java.util.ArrayList;
import java.util.List;

public class BowlingValidationImpl implements BowlingValidation {
    @Override
    public String validate(List<Frame> frames) {
        return !validateTenPlays(frames) ? "Bad input, more than 10 plays!" :
                        !validatePinsNumberFromPlays(frames) ? "Bad input, invalid amount of pins!" :
                                "";
    }

    private boolean validatePinsNumberFromPlays(List<Frame> frames) {
        return frames.stream().allMatch(this::validatePinsNumber);
    }

    private boolean validatePinsNumber(Frame frame) {
        List<String> pins = new ArrayList<>();
        pins.add(frame.getFirstBallScore());
        pins.add(frame.getSecondBallScore());
        pins.add(frame.getFinalBallScore());

        return pins.stream().allMatch(el -> {
            int numberOfPins = Helper.getIntegerValue(el);
            return numberOfPins <= 10 && numberOfPins >= 0;
        });
    }

    private boolean validateTenPlays(List<Frame> frames) {
        return frames.size() <= 10;
    }
}
