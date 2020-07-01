package com.bowling.play.Model;


import com.bowling.play.Utils.Helper;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Frame {

    private String firstBallScore;
    private String secondBallScore;
    private String finalBallScore;
    private String totalScore;
    private int ball;

    public String getFirstBallScore() {
        return firstBallScore;
    }

    public void setFirstBallScore(String firstBallScore) {
        this.firstBallScore = firstBallScore;
    }

    public String getSecondBallScore() {
        return secondBallScore;
    }

    public void setSecondBallScore(String secondBallScore) {
        this.secondBallScore = secondBallScore;
    }

    public String getFinalBallScore() {
        return finalBallScore;
    }

    public void setFinalBallScore(String finalBallScore) {
        this.finalBallScore = finalBallScore;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }


    public boolean isStrike() {
        return (this.firstBallScore.equals("10") || this.secondBallScore.equals("10")) && this.ball < 10;
    }

    public boolean isSpare() {
        return !this.isStrike() && Helper.getIntegerValue(this.firstBallScore) + Helper.getIntegerValue(this.secondBallScore) == 10 && this.ball < 10;
    }

}
