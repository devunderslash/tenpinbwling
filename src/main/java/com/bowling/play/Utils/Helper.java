package com.bowling.play.Utils;

public class Helper {

    static public int getIntegerValue(String score) {
        if(score == null)
        {
            return 0;
        }else {
            return (score != null) ? score.equals("F") ? 0 : Integer.parseInt(score) : 0;
        }
    }

}
