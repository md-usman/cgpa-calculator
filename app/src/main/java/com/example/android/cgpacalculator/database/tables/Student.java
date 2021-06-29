package com.example.android.cgpacalculator.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "student_table")
public class Student {

    @PrimaryKey
    @ColumnInfo(name = "usn")
    @NonNull
    private String usn;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "branch_name")
    private String branchName;

    public Student(String usn, String name, String branchName) {
        this.usn = usn;
        this.name = name;
        this.branchName = branchName;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
