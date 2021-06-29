package com.example.android.cgpacalculator;

public class Utils {

    public static int getMarksPoints(int marks) {
        if (marks >= 90) return 10;
        if (marks >= 80) return 9;
        if (marks >= 70) return 8;
        if (marks >= 60) return 7;
        if (marks >= 45) return 6;
        if (marks >= 40) return 4;
        return 0;
    }

}
