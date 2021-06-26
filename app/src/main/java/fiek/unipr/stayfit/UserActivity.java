package fiek.unipr.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {
    Button btnSubmit;
    Animation scale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setAlpha(0f);

        btnSubmit.animate().alpha(1f).setDuration(2000);

        //
        scale = AnimationUtils.loadAnimation(this, R.anim.scal_button_animation);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSubmit.startAnimation(scale);
            }
        });
    }
}