package com.example.android.cgpacalculator.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.cgpacalculator.R;
import com.example.android.cgpacalculator.database.tables.Marks;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.cgpacalculator.Data.getSubjectCredits;
import static com.example.android.cgpacalculator.Utils.getMarksPoints;

public class MarksAdapter extends RecyclerView.Adapter<MarksAdapter.MarksHolder> {

    private List<Marks> allSemMarks = new ArrayList<>();
    private boolean isEditMode = false;

    public List<Marks> getAllSemMarks() {
        return allSemMarks;
    }

    public void setEditMode(boolean editMode) {
        isEditMode = editMode;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public MarksHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.recycler_view_marks_list, parent, false);
       return new MarksHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MarksHolder holder, int position) {

        holder.bind(allSemMarks.get(position));

    }


    public void setAllSemMarks(List<Marks> marksList) {
        this.allSemMarks = marksList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return allSemMarks.size();
    }

    public class MarksHolder extends RecyclerView.ViewHolder {

        private final TextInputLayout subjectCode;
        private final TextInputEditText subjectMarks;
            private Marks mMarks = null;

        public MarksHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            subjectCode = itemView.findViewById(R.id.subject_code);
            subjectMarks = itemView.findViewById(R.id.subject_marks);
            subjectMarks.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (mMarks != null) {
                        if(!s.toString().equals("")) {
                            try {
                                int marksEdited = Integer.parseInt(s.toString());
                                if(marksEdited <= 100) {
                                    mMarks.setMarks(marksEdited);
                                    int points = getMarksPoints(marksEdited);
                                    mMarks.setPoints(points * getSubjectCredits(mMarks.getSubjectCode()));
                                    subjectCode.setErrorEnabled(false);
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
            subjectCode.setError("invalid");
            mMarks.setMarks(0);
        }

        public void bind(Marks marks) {
            mMarks = marks;
            subjectCode.setHint(marks.getSubjectCode());
            subjectMarks.setText(String.valueOf(marks.getMarks()));

            subjectMarks.setEnabled(isEditMode);
        }
    }

}
