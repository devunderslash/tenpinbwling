package com.bowling.play.Validation;

import com.bowling.play.Model.Frame;

import java.util.List;

public interface BowlingValidation {
    String validate(List<Frame> frames);
}
