package com.example.android.cgpacalculator.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.cgpacalculator.R;
import com.example.android.cgpacalculator.database.tables.Sgpa;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SemListAdapter extends RecyclerView.Adapter<SemListAdapter.SemSgpaHolder> {

    public NavigationListener navigationListener;
    private List<Sgpa> allSemSgpaList = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public SemSgpaHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_sem_list, parent, false);
        return new SemSgpaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SemSgpaHolder holder, int position) {
        holder.bind(allSemSgpaList.get(position));
    }

    @Override
    public int getItemCount() {
        return allSemSgpaList.size();
    }


    public void setAllSemSgpaList(List<Sgpa> sgpaList) {
        this.allSemSgpaList = sgpaList;
        notifyDataSetChanged();
    }

    public interface NavigationListener {
        void onNavigate(Sgpa sgpa);
    }

    public class SemSgpaHolder extends RecyclerView.ViewHolder {

        private final TextView semId;
        private final TextView semPoints;
        private final TextView semSgpa;

        public SemSgpaHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            semId = itemView.findViewById(R.id.semester_id);
            semPoints = itemView.findViewById(R.id.semester_points);
            semSgpa = itemView.findViewById(R.id.semester_sgpa);


        }

        public void bind(Sgpa sgpa) {
            semId.setText(String.valueOf(sgpa.getSemId()));
            semPoints.setText(String.valueOf(sgpa.getPoints()));
            semSgpa.setText(String.format(Locale.ENGLISH, "%.2f", Math.round(sgpa.getSgpa() * 100.0) / 100.0));
            itemView.setOnClickListener(v -> navigationListener.onNavigate(sgpa));
        }
    }
}
