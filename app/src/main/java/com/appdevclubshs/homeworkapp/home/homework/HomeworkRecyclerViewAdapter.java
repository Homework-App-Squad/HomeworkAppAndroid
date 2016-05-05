package com.appdevclubshs.homeworkapp.home.homework;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appdevclubshs.homeworkapp.home.homework.HomeworkFragment.OnHomeworkSelectedListener;
import com.appdevclubshs.homeworkapp.R;

import java.util.ArrayList;
import java.util.List;


public class HomeworkRecyclerViewAdapter extends RecyclerView.Adapter<HomeworkRecyclerViewAdapter.ViewHolder> {

    private final List<HomeworkAssignment> assignments;
    private final OnHomeworkSelectedListener onHomeworkSelectedListener;

    public HomeworkRecyclerViewAdapter(OnHomeworkSelectedListener listener) {
        assignments = new ArrayList<>();

        assignments.add(new HomeworkAssignment("Ryan Anderson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));
        assignments.add(new HomeworkAssignment("Ronald Apkinson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));
        assignments.add(new HomeworkAssignment("Ronald Apkinson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));
        assignments.add(new HomeworkAssignment("Ronald Apkinson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));
        assignments.add(new HomeworkAssignment("Ronald Apkinson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));
        assignments.add(new HomeworkAssignment("Ronald Apkinson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));
        assignments.add(new HomeworkAssignment("Ronald Apkinson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));
        assignments.add(new HomeworkAssignment("Ronald Apkinson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));
        assignments.add(new HomeworkAssignment("Ronald Apkinson", "00000000", "Read LOTF ch.1", "2/2/2016", "English 10", 1, 0));

        onHomeworkSelectedListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_homework, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = assignments.get(position);
        holder.descriptionView.setText(assignments.get(position).description);
        holder.classNameView.setText(assignments.get(position).className);
        holder.dueDateView.setText(assignments.get(position).dueDate);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onHomeworkSelectedListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    onHomeworkSelectedListener.onHomeworkSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView descriptionView;
        public final TextView classNameView;
        public final TextView dueDateView;
        public HomeworkAssignment mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            descriptionView = (TextView) view.findViewById(R.id.description);
            classNameView = (TextView) view.findViewById(R.id.className);
            dueDateView = (TextView) view.findViewById(R.id.dueDate);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + descriptionView.getText() + "'";
        }
    }
}
