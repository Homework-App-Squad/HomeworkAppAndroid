package com.appdevclubshs.homeworkapp.home.homework;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appdevclubshs.homeworkapp.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.FirebaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnHomeworkSelectedListener}
 * interface.
 */
public class HomeworkFragment extends Fragment {

    private OnHomeworkSelectedListener mListener;
    private RecyclerView recyclerView;
    private Firebase firebaseRef;
    private ArrayList<String> myClasses = new ArrayList<String>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HomeworkFragment() {
    }

    @SuppressWarnings("unused")
    public static HomeworkFragment newInstance() {
        HomeworkFragment fragment = new HomeworkFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if (getArguments() != null) {
        //    mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homework_list, container, false);
        firebaseRef = new Firebase("https://dalilabs.firebaseio.com/");

        //TODO read from preferances
        myClasses.add("Pickett Period 1");
        myClasses.add("Rector Period 4");

        if (view instanceof RecyclerView) {
            recyclerView = (RecyclerView) view;
            Context context = view.getContext();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        final HomeworkRecyclerViewAdapter mainAdapter = new HomeworkRecyclerViewAdapter(mListener);
        final List<HomeworkAssignment> assignmentArray = mainAdapter.getAssignments();
        for(final String eachClass: myClasses){
            Firebase assignmentRef = firebaseRef.child("Saratoga High School").child(eachClass)
                    .child("Assignments");
            assignmentRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Map m = (Map)dataSnapshot.getValue();
                    assignmentArray.add(new HomeworkAssignment((String)m.get("createdByDisplayName"),
                            (String)m.get("createdByID"), (String)m.get("description"), (String)m.get("dueDate"),
                            eachClass, (Long)m.get("datePostNum"), (Long)m.get("votes")));
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Map m = (Map)dataSnapshot.getValue();
                    HomeworkAssignment changedAssignment = new HomeworkAssignment((String)m.get("createdByDisplayName"),
                            (String)m.get("createdByID"), (String)m.get("description"), (String)m.get("dueDate"),
                            eachClass, (Long)m.get("datePostNum"), (Long)m.get("votes"));
                    /*for(HomeworkAssignment hw: mainAdapter.getAssignments()){
                        if(hw.equals(changedAssignment));//TODO
                    }*/
                    Log.d("HomeworkFragment", s);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    //TODO implement child removed logic
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    //ignore lolz
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }

        recyclerView.setAdapter(mainAdapter);


        /*
        for(final String eachClass: myClasses){ //fuck this logic. here marks the battle scars of dark times
            Firebase pickettPer1AssignemntsRef = firebaseRef.child("Saratoga High School").child(eachClass)
                    .child("Assignments");
            FirebaseRecyclerAdapter<HomeworkAssignment, HomeworkAssignmentViewHolder> adapter =
                    new FirebaseRecyclerAdapter<HomeworkAssignment, HomeworkAssignmentViewHolder>(HomeworkAssignment.class, R.layout.fragment_homework,
                            HomeworkAssignmentViewHolder.class, pickettPer1AssignemntsRef) {

                        @Override
                        protected void populateViewHolder(HomeworkAssignmentViewHolder homeworkViewHolder, HomeworkAssignment hw, int position) {
                            homeworkViewHolder.dueDate.setText(hw.dueDate);
                            homeworkViewHolder.description.setText(hw.description);
                            homeworkViewHolder.className.setText(eachClass);
                        }
                    };
            recyclerView.setAdapter(adapter);
        }
        */





    }

    public static class HomeworkAssignmentViewHolder extends RecyclerView.ViewHolder {
        TextView description, className, dueDate;
        public HomeworkAssignmentViewHolder(View v){
            super(v);
            description = (TextView)v.findViewById(R.id.description);
            className = (TextView)v.findViewById(R.id.className);
            dueDate = (TextView)v.findViewById(R.id.dueDate);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeworkSelectedListener) {
            mListener = (OnHomeworkSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnHomeworkSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnHomeworkSelectedListener {
        void onHomeworkSelected(HomeworkAssignment item);
    }
}
