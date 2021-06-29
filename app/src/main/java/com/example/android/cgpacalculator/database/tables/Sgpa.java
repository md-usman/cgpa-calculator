package com.example.android.cgpacalculator.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "sgpa_table")

public class Sgpa {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "sem_id")
    private int semId;
    @ColumnInfo(name = "sgpa")
    private double sgpa;
    @ColumnInfo(name = "points")
    private int points;

    public Sgpa(int semId, double sgpa, int points) {
        this.semId = semId;
        this.sgpa = sgpa;
        this.points = points;
    }

    public int getSemId() {
        return semId;
    }

    public void setSemId(int semId) {
        this.semId = semId;
    }

    public double getSgpa() {
        return sgpa;
    }

    public void setSgpa(float sgpa) {
        this.sgpa = sgpa;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
