package com.example.android.cgpacalculator.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.cgpacalculator.MainViewModel;
import com.example.android.cgpacalculator.R;
import com.example.android.cgpacalculator.database.tables.Cgpa;
import com.example.android.cgpacalculator.database.tables.Sgpa;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;


public class ReportFragment extends Fragment {

    MainViewModel viewModel;
    RecyclerView sgpaSemListRecyclerView;
    TextView student_cgpa;
    TextView cgpa_percentage;
    LiveData<List<Cgpa>> cgpa;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        student_cgpa = view.findViewById(R.id.student_cgpa);
        cgpa_percentage = view.findViewById(R.id.cgpa_percentage);

        viewModel.getStudentCgpa().observe(getViewLifecycleOwner(), new Observer<List<Cgpa>>() {
            @Override
            public void onChanged(List<Cgpa> cgpas) {
                double tempCgpa;
                String percentage;
                if(cgpas.size() == 0 || cgpas.get(0).getCgpa() == 0) {
                    tempCgpa = 0.0;
                    percentage = String.valueOf(0.0);
                } else {
                    tempCgpa = Math.round(cgpas.get(0).getCgpa() * 100.0) / 100.0;
                    percentage = "(" + String.format(Locale.ENGLISH,"%.2f",(tempCgpa - 0.75) * 10) + "%)";
                }
                student_cgpa.setText(String.valueOf(tempCgpa));
                cgpa_percentage.setText(percentage);
            }
        });

        sgpaSemListRecyclerView = view.findViewById(R.id.recycler_view_sem);
        sgpaSemListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        sgpaSemListRecyclerView.setHasFixedSize(true);

        SemListAdapter adapter = new SemListAdapter();
        sgpaSemListRecyclerView.setAdapter(adapter);
        adapter.navigationListener = (sgpa) -> {
            Bundle bundle = new Bundle();
            Log.d("TESTING", "onViewCreated: semid" + sgpa.getSemId());
            bundle.putInt("semId", sgpa.getSemId());
            Navigation.findNavController(view).navigate(R.id.to_marksFragment, bundle);
        };

        viewModel.getAllSemLiveData().observe(getViewLifecycleOwner(), adapter::setAllSemSgpaList);
    }


}