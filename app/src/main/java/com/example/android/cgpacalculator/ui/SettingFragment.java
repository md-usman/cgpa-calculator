package com.example.android.cgpacalculator.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.android.cgpacalculator.MainViewModel;
import com.example.android.cgpacalculator.R;

import org.jetbrains.annotations.NotNull;

public class SettingFragment extends Fragment {

    TextView studentName;
    TextView studentUsn;
    TextView studentBranch;
    MainViewModel viewModel;
    ImageButton editInfo;
    TextView githubLink;
    Button resetButton;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.getAllStudentDetails();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        studentName = view.findViewById(R.id.student_name);
        studentUsn = view.findViewById(R.id.student_usn);
        studentBranch = view.findViewById(R.id.student_branch);
        editInfo = view.findViewById(R.id.edit_info);
        githubLink = view.findViewById(R.id.github_link);

        viewModel.getAllStudentDetails().observe(getViewLifecycleOwner(), students -> {
            if (students != null && students.size() > 0) {

                studentName.setText(students.get(0).getName());
                studentUsn.setText(students.get(0).getUsn());
                studentBranch.setText(students.get(0).getBranchName());
            }

        });

        githubLink.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/md-usman/cgpa-calculator"));
            startActivity(intent);
        });

        resetButton = view.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(v -> new AlertDialog.Builder(getContext())
                .setTitle("Reset All Marks")
                .setMessage("Are you sure you want to reset your Marks ?")
                .setPositiveButton("Yes", (dialog, which) -> viewModel.resetDatabase())
                .setNegativeButton("No", null)
                .show());

        editInfo.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.to_editInfo));

    }
}