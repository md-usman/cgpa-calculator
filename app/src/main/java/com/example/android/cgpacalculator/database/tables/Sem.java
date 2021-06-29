package com.example.android.cgpacalculator.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Sem {

    private int semId;
    private int semCredits;

    public Sem(int semId, int semCredits) {
        this.semId = semId;
        this.semCredits = semCredits;
    }

    public int getSemId() {
        return semId;
    }

    public void setSemId(int semId) {
        this.semId = semId;
    }

    public int getSemCredits() {
        return semCredits;
    }

    public void setSemCredits(int semCredits) {
        this.semCredits = semCredits;
    }
}
