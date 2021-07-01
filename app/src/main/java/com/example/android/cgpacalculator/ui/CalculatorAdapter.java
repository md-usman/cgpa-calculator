package com.example.android.cgpacalculator.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.cgpacalculator.R;
import com.example.android.cgpacalculator.database.tables.Subjects;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.cgpacalculator.Utils.getMarksPoints;

public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.CalcMarksHolder> {

    List<Subjects> subjectsList = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public CalculatorAdapter.CalcMarksHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_marks_list, parent, false);
        return new CalcMarksHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CalculatorAdapter.CalcMarksHolder holder, int position) {

        holder.bind(subjectsList.get(position));

    }

    @Override
    public int getItemCount() {
        return subjectsList.size();
    }

    public List<Subjects> getAllSubjectMarks() {
        return subjectsList;
    }

    public void setAllSubjectMarks(List<Subjects> subjectsList) {
        this.subjectsList.clear();
        this.subjectsList.addAll(subjectsList);
        notifyDataSetChanged();
    }


    public static class CalcMarksHolder extends RecyclerView.ViewHolder {

        private final TextInputLayout subject_code;
        private final TextInputEditText subject_marks;
        Subjects mSubjects = null;

        public CalcMarksHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            subject_code = itemView.findViewById(R.id.subject_code);
            subject_marks = itemView.findViewById(R.id.subject_marks);
            subject_marks.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    if (mSubjects != null) {
                        if (!s.toString().equals("")) {
                            try {
                                int marksEdited = Integer.parseInt(s.toString());
                                if (marksEdited <= 100) {
                                    mSubjects.setMarks(marksEdited);
                                    mSubjects.setSubjectCredit(getMarksPoints(marksEdited) * mSubjects.getCredits());
                                    subject_code.setErrorEnabled(false);
                                } else {
                                    showError();
                                }
                            } catch (Exception e) {
                                showError();
                            }
                        } else {
                            showError();
                        }
                    }
                }
            });
        }

        public void showError() {
            subject_code.setError("invalid");
            mSubjects.setMarks(0);
        }

        public void bind(Subjects subjects) {
            mSubjects = subjects;
            subject_code.setHint(subjects.getSubjectCode());
            subject_marks.setText(String.valueOf(subjects.getMarks()));
        }
    }

}
