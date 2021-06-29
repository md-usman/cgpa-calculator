package com.example.android.cgpacalculator.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "cgpa_table")
public class Cgpa {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "cgpa")
    private Double cgpa = 0.0;

    public Cgpa(@NotNull Double cgpa) {
        this.cgpa = cgpa;
    }

    @NotNull
    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(@NotNull Double cgpa) {
        this.cgpa = cgpa;
    }
}
