package com.example.android.cgpacalculator.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "marks_table",
        primaryKeys = {"sem_id", "subject_code"})
public class Marks {

    @NonNull
    @ColumnInfo(name = "sem_id")
    private int semId;
    @NonNull
    @ColumnInfo(name = "subject_code")
    private String subjectCode;
    @ColumnInfo(name = "marks")
    private int marks;
    @ColumnInfo(name = "points")
    private int points;

    public Marks(int semId, String subjectCode, int marks, int points) {
        this.semId = semId;
        this.subjectCode = subjectCode;
        this.marks = marks;
        this.points = points;
    }

    public int getSemId() {
        return semId;
    }

    public void setSemId(int semId) {
        this.semId = semId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "semId=" + semId +
                ", subjectCode='" + subjectCode + '\'' +
                ", marks=" + marks +
                ", points=" + points +
                '}';
    }
}
