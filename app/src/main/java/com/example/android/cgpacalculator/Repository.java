package com.example.android.cgpacalculator;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.android.cgpacalculator.database.StudentDao;
import com.example.android.cgpacalculator.database.StudentDatabase;
import com.example.android.cgpacalculator.database.tables.Cgpa;
import com.example.android.cgpacalculator.database.tables.Marks;
import com.example.android.cgpacalculator.database.tables.Sgpa;
import com.example.android.cgpacalculator.database.tables.Student;

import java.util.List;

public class Repository {

    private final StudentDao studentDao;
    StudentDatabase studentDatabase;

    public Repository(Application application) {
        studentDatabase = StudentDatabase.getInstance(application);
        studentDao = studentDatabase.databaseDao();
    }

    public LiveData<List<Student>> getStudentDetails() {
        return studentDao.getStudentDetails();
    }

    public void insert(Student student) {
        studentDao.insert(student);
    }

    public void deleteAllStudentDetails() {
        studentDao.deleteAllStudentDetails();
    }

    public LiveData<List<Cgpa>> getStudentCgpa() {
        return studentDao.getStudentCgpa();
    }

    public LiveData<List<Sgpa>> getAllSemSgpa() {
        return studentDao.getAllSemSgpa();
    }

    public List<Sgpa> getAllSemSgpaToCgpa() {
        return studentDao.getAllSemSgpaToCgpa();
    }

    public LiveData<List<Double>> getSemSgpa(int semId) {
        return studentDao.getSemSgpa(semId);
    }

    public LiveData<List<Marks>> getSemMarks(int semId) {
        return studentDao.getSemMarks(semId);
    }

    public void insertAllMarks(List<Marks> marksList) {
        studentDao.insertAllMarks(marksList);
    }

    public List<Integer> getPointsTotal(int semId) {
        return studentDao.getPointsTotal(semId);
    }

    public void insert(Sgpa sgpa) {
        studentDao.insert(sgpa);
    }

    public void deleteAllCgpa() {
        studentDao.deleteAllCgpa();
    }

    public void insert(Cgpa cgpa) {
        studentDao.insert(cgpa);
    }

    public void resetDatabase() {
        StudentDatabase.resetDatabase();
    }

}
