package com.example.android.cgpacalculator.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cgpacalculator.R;
import com.example.android.cgpacalculator.database.tables.Subjects;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.android.cgpacalculator.Data.getFirstSemSubjects;
import static com.example.android.cgpacalculator.Data.getSelectedSemSubjects;


public class CalculatorFragment extends Fragment {

    Spinner semesterSpinner;
    RecyclerView calculatorRecyclerView;
    CalculatorAdapter calcAdapter;
    int selectedSem;
    List<Subjects> subjectsList;
    Button calculateSgpa;
    TextView calculatedSgpa;
    TextView calculatedPercentage;
    TextView clearText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        semesterSpinner = view.findViewById(R.id.semester_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.semester_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(adapter);

        calcAdapter = new CalculatorAdapter();

        semesterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedSem = position + 1;
                subjectsList = getSelectedSemSubjects(selectedSem);
                calcAdapter.setAllSubjectMarks(subjectsList);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        calcAdapter.setAllSubjectMarks(getFirstSemSubjects());
        calculatorRecyclerView = view.findViewById(R.id.calculator_recycler_view);
        calculatorRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        calculatorRecyclerView.setHasFixedSize(true);
        calculatorRecyclerView.setAdapter(calcAdapter);

        calculatedSgpa = view.findViewById(R.id.calculated_sgpa);
        calculatedPercentage = view.findViewById(R.id.calculated_percentage);
        clearText = view.findViewById(R.id.clear_text);

        calculateSgpa = view.findViewById(R.id.calculate_sgpa);
        calculateSgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Subjects> allSubjectsListWithMarks = new ArrayList<>();
                allSubjectsListWithMarks = calcAdapter.getAllSubjectMarks();
                int semCredit = 0;
                int totalCredits = 0;
                for(Subjects subject: allSubjectsListWithMarks) {
                    totalCredits += subject.getSubjectCredit();
                    semCredit += subject.getCredits();
                }
                double sgpa = (float)totalCredits / semCredit;
                double finalSgpa = Math.round(sgpa * 100.0) / 100.0;
                calculatedSgpa.setText(String.format(Locale.ENGLISH, "%.2f", finalSgpa));
                calculatedSgpa.setVisibility(View.VISIBLE);
                String percentage = "(" + String.format(Locale.ENGLISH,"%.2f",( finalSgpa - 0.75) * 10) + "%)";
                calculatedPercentage.setText(percentage);
                calculatedPercentage.setVisibility(View.VISIBLE);
                clearText.setVisibility(View.VISIBLE);

                // hiding the keyboard
                InputMethodManager imm = (InputMethodManager)requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }
        });

        clearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatedPercentage.setVisibility(View.GONE);
                calculatedSgpa.setVisibility(View.GONE);
                clearText.setVisibility(View.GONE);
                calcAdapter.setAllSubjectMarks(getSelectedSemSubjects(semesterSpinner.getSelectedItemPosition() + 1));
            }
        });



    }
}