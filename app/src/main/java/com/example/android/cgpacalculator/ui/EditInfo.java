package com.example.android.cgpacalculator.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.cgpacalculator.MainViewModel;
import com.example.android.cgpacalculator.R;
import com.example.android.cgpacalculator.database.tables.Student;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

public class EditInfo extends DialogFragment {

    TextInputEditText studentName;
    TextInputEditText studentUsn;
    Spinner branchSpinner;
    MainViewModel viewModel;
    Button saveStudentInfo;
    Button cancelStudentInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.getAllStudentDetails();

        return inflater.inflate(R.layout.fragment_edit_info, container, false);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        branchSpinner = view.findViewById(R.id.edit_branch_spinner);
        studentName = view.findViewById(R.id.edit_student_name);
        studentUsn = view.findViewById(R.id.edit_student_usn);
        saveStudentInfo = view.findViewById(R.id.save_student_info);
        cancelStudentInfo = view.findViewById(R.id.cancel_student_info);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.branches_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchSpinner.setAdapter(adapter);

        saveStudentInfo.setOnClickListener(v -> {
            viewModel.editStudentInfo(new Student(studentUsn.getText().toString(), studentName.getText().toString(), branchSpinner.getSelectedItem().toString()));
            dismiss();
        });
        cancelStudentInfo.setOnClickListener(v -> dismiss());

    }


}