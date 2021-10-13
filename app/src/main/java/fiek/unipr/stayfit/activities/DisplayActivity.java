package fiek.unipr.stayfit.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import fiek.unipr.stayfit.R;

public class DisplayActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    Integer count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(50);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
        new MyTask().execute(50);
    }

    class MyTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... params) {
            for (; count <= params[0]; count++) {
                try {
                    Thread.sleep(50);
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Task Completed.";
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
            startActivity(new Intent(DisplayActivity.this, LoginActivity.class));
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }
    }
}