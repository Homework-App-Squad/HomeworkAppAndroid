package com.appdevclubshs.homeworkapp.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appdevclubshs.homeworkapp.R;
import com.appdevclubshs.homeworkapp.home.ClassesFragment.OnClassSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class ClassesRecyclerViewAdapter extends RecyclerView.Adapter<ClassesRecyclerViewAdapter.ViewHolder> {

    private final List<SchoolClass> schoolClasses;
    private final OnClassSelectedListener onClassSelectedListener;

    public ClassesRecyclerViewAdapter(OnClassSelectedListener listener) {
        //schoolClasses = items;
        schoolClasses = new ArrayList<SchoolClass>();
        schoolClasses.add(new SchoolClass("Keys English 10"));
        onClassSelectedListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_classes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = schoolClasses.get(position);
        holder.classNameView.setText(schoolClasses.get(position).className);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onClassSelectedListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    onClassSelectedListener.onClassSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return schoolClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView classNameView;
        public SchoolClass mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            classNameView = (TextView) view.findViewById(R.id.classNameInClassesFragment);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + classNameView.getText() + "'";
        }
    }
}
