package fiek.unipr.stayfit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import fiek.unipr.stayfit.R;

public class UserActivity extends AppCompatActivity {


    private EditText etWeek, etWeight;
    private Button btnSubmit, btnRead;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("weekNweight");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        etWeek = findViewById(R.id.etWeek);
        etWeight = findViewById(R.id.etWeight);
        btnSubmit = findViewById(R.id.button);
        btnRead = findViewById(R.id.button2);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String week = etWeek.getText().toString();
                String weight = etWeight.getText().toString();

                HashMap<String, String> progressMap = new HashMap<>();

                progressMap.put("week", week);
                progressMap.put("weight", weight);
                root.setValue(progressMap);

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserActivity.this, ShowActivity.class));
            }
        });
    }
}