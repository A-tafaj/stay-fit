package fiek.unipr.stayfit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fiek.unipr.stayfit.R;

public class ExercisesActivity extends AppCompatActivity {

    private TextView mExerciseName;
    private TextView mExerciseDescription;
    private TextView mExerciseTitle;
    private TextView mExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mExerciseName = findViewById(R.id.text_exercise);
        mExerciseDescription = findViewById(R.id.description);
        mExerciseTitle = findViewById(R.id.method);
        mExercise = findViewById(R.id.desc);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("ExerciseName");
        String Description = intent.getExtras().getString("ExerciseDescription");
        String ExerciseTitle = intent.getExtras().getString("ExerciseTitle");
        String Exercise = intent.getExtras().getString("Exercise");

        mExerciseName.setText(Title);
        mExerciseDescription.setText(Description);
        mExerciseTitle.setText(ExerciseTitle);
        mExercise.setText(Exercise);
    }
}