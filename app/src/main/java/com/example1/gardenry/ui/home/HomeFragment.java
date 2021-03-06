package com.example1.gardenry.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example1.gardenry.AllPlants;
import com.example1.gardenry.NewPlant;
import com.example1.gardenry.Notes;
import com.example1.gardenry.R;
import com.example1.gardenry.RequestStatus;
import com.example1.gardenry.SplashScreen;
import com.example1.gardenry.ToDo;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    FirebaseAuth auth;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        auth=FirebaseAuth.getInstance();
        View root= inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });


        CardView allPlants = root.findViewById(R.id.cv_all_plants_home);
        allPlants.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    allPlants.setCardElevation(35);
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    allPlants.setCardElevation(6);
                    startActivity(new Intent(getContext(), AllPlants.class));
                }
                return true;
            }
        });

        CardView newPlant = root.findViewById(R.id.cv_new_plant_home);
        newPlant.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    newPlant.setCardElevation(35);
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    newPlant.setCardElevation(6);
                    startActivity(new Intent(getContext(), NewPlant.class));
                }
                return true;
            }
        });

        CardView newRequest = root.findViewById(R.id.cv_new_request_home);
        newRequest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    newRequest.setCardElevation(35);
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    newRequest.setCardElevation(6);
                    startActivity(new Intent(getContext(), RequestStatus.class));
                }
                return true;
            }
        });

        CardView notes = root.findViewById(R.id.cv_notes_home);
        notes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    notes.setCardElevation(35);
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    notes.setCardElevation(6);
                    startActivity(new Intent(getContext(), Notes.class));
                }
                return true;
            }
        });

        CardView toDo = root.findViewById(R.id.cv_todo_home);
        toDo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    toDo.setCardElevation(35);
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    toDo.setCardElevation(6);
                    startActivity(new Intent(getContext(), ToDo.class));
                }
                return true;
            }
        });
        CardView logout = root.findViewById(R.id.log_out);
        logout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    logout.setCardElevation(35);
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){

                    logout.setCardElevation(6);

                    auth.signOut();
                    Toast.makeText(getContext(),"Logout!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), SplashScreen.class));
                }
                return true;
            }
        });


        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}