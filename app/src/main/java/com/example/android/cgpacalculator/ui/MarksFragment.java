package com.example.android.cgpacalculator.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.cgpacalculator.MainViewModel;
import com.example.android.cgpacalculator.R;

import org.jetbrains.annotations.NotNull;

public class MarksFragment extends Fragment implements LifecycleObserver {

    TextView semSgpa;
    MainViewModel viewModel;
    RecyclerView semMarksRecyclerView;
    int semId = 1;
    AppCompatToggleButton toggleButton;
    MarksAdapter adapter;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            getActivity().getLifecycle().addObserver(this);
        }
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            semId = getArguments().getInt("semId", 1);
        }

        adapter = new MarksAdapter();

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        Log.d("TESTING", "onCreate: sem id in marks fragment : " + semId);
        viewModel.getSemMarks(semId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        semMarksRecyclerView = view.findViewById(R.id.recycler_view_marks);
        semMarksRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        semMarksRecyclerView.setHasFixedSize(true);

        semMarksRecyclerView.setAdapter(adapter);

        viewModel.getSemMarks(semId).observe(getViewLifecycleOwner(), adapter::setAllSemMarks);


        toggleButton = view.findViewById(R.id.switch_compat);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adapter.setEditMode(isChecked);
                if (!isChecked) {
                    Log.d("TESTING", "Marks List" + adapter.getAllSemMarks());
                    viewModel.insertAndValidateCgpa(adapter.getAllSemMarks(), semId);
                }
            }
        });

        semSgpa = view.findViewById(R.id.sem_sgpa);
        viewModel.getSemSgpa(semId).observe(getViewLifecycleOwner(), doubles -> semSgpa.setText(String.valueOf(doubles.get(0))));

    }


    @Override
    public void onDestroyView() {
        ((MainActivity) requireActivity()).setBottomNavVisibility(View.VISIBLE);
        super.onDestroyView();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreated() {
        if (getActivity() != null) {
            getActivity().getLifecycle().removeObserver(this);
            ((MainActivity) requireActivity()).setBottomNavVisibility(View.GONE);
        }
    }

}