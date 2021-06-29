package com.example.android.cgpacalculator;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.cgpacalculator.database.tables.*;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Executors;

import static com.example.android.cgpacalculator.Data.getSemCredits;
import static com.example.android.cgpacalculator.database.StudentDatabase.databaseWriteExecutor;

public class MainViewModel extends AndroidViewModel {

    private final Repository repository;


    public MainViewModel(@NonNull @NotNull Application application) {
        super(application);

        repository = new Repository(application);
    }

    public LiveData<List<Cgpa>> getStudentCgpa() {
        return repository.getStudentCgpa();
    }

    public LiveData<List<Double>> getSemSgpa(int semId) {
        return repository.getSemSgpa(semId);
    }

    public LiveData<List<Marks>> getSemMarks(int semId) {
        return repository.getSemMarks(semId);
    }

    public LiveData<List<Sgpa>> getAllSemLiveData() {
        return repository.getAllSemSgpa();
    }



    public void editStudentInfo(Student student) {

        Executors.newSingleThreadExecutor().execute(() -> {
            repository.deleteAllStudentDetails();
            repository.insert(student);
        });
    }

    public LiveData<List<Student>> getAllStudentDetails() {
        return repository.getStudentDetails();
    }

    public void insertAndValidateCgpa(List<Marks> marksList, int semId) {
        Executors.newSingleThreadExecutor().execute(() -> {
            repository.insertAllMarks(marksList);
            Log.d("TESTING", "Marks List: " + marksList);
            List<Integer> creditSums = repository.getPointsTotal(semId);
            double sgpa = (double)creditSums.get(0) / getSemCredits(semId);
            int semPoints = creditSums.get(0);
            repository.insert(new Sgpa(semId, sgpa, semPoints));

            List<Sgpa> allSemSgpas = repository.getAllSemSgpaToCgpa();
            double semCreditPointsTotal = 0;
            double semCreditsTotal = 0;
            for(Sgpa sgpa1: allSemSgpas) {
                if(sgpa1.getPoints() != 0) {
                    semCreditPointsTotal += sgpa1.getPoints();
                    semCreditsTotal += getSemCredits(sgpa1.getSemId());
                }
            }

            repository.deleteAllCgpa();
            Double calculatedCgpa = semCreditPointsTotal / semCreditsTotal;
            try {
                repository.insert(new Cgpa(calculatedCgpa));
            } catch (Exception e) {
                repository.insert(new Cgpa(0.0));
            }

        });
    }

}
