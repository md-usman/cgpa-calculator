package com.example.android.cgpacalculator.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.cgpacalculator.database.tables.Cgpa;
import com.example.android.cgpacalculator.database.tables.Marks;
import com.example.android.cgpacalculator.database.tables.Sgpa;
import com.example.android.cgpacalculator.database.tables.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insert(Student student);

    @Query("DELETE FROM student_table")
    void deleteAllStudents();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Sgpa sgpa);

    @Query("DELETE FROM SGPA_TABLE")
    void deleteAllSgpa();

    @Insert
    void insert(Marks marks);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllMarks(List<Marks> marksList);

    @Query("DELETE FROM MARKS_TABLE")
    void deleteAllMarks();

    @Insert
    void insert(Cgpa cgpa);

    @Query("DELETE FROM CGPA_TABLE")
    void deleteAllCgpa();

    @Query("DELETE FROM STUDENT_TABLE")
    void deleteAllStudentDetails();

    @Query("SELECT * FROM student_table")
    LiveData<List<Student>> getStudentDetails();

    @Query("SELECT * FROM cgpa_table")
    LiveData<List<Cgpa>> getStudentCgpa();

    @Query("SELECT * FROM sgpa_table")
    LiveData<List<Sgpa>> getAllSemSgpa();

    @Query("SELECT * FROM sgpa_table")
    List<Sgpa> getAllSemSgpaToCgpa();

    @Query("SELECT sgpa FROM SGPA_TABLE WHERE SEM_ID = :semId")
    LiveData<List<Double>> getSemSgpa(int semId);

    @Query("SELECT * FROM MARKS_TABLE WHERE SEM_ID = :semId")
    LiveData<List<Marks>> getSemMarks(int semId);

    @Query("SELECT SUM(points) FROM marks_table WHERE SEM_iD=:semId GROUP BY SEM_ID")
    List<Integer> getPointsTotal(int semId);

}
