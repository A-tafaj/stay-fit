package fiek.unipr.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.workoutapp.adapter.RecyclerViewAdapter;
import com.example.workoutapp.adapter.WorkoutsAdapter;
import com.example.workoutapp.model.Exercises;
import com.example.workoutapp.model.SliderAdapter;
import com.example.workoutapp.model.SliderItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;

    List<Exercises> exercise;


    RecyclerView workoutRecycler;
    WorkoutsAdapter workoutsAdapter;
    List<Workouts> workoutsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager2 = findViewById(R.id.viewPagerImageSlider);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.fitnes));
        sliderItems.add(new SliderItem(R.drawable.health));
        sliderItems.add(new SliderItem(R.drawable.give));
        sliderItems.add(new SliderItem(R.drawable.chest));


        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r + 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); //slide duration 3seconds
            }
        });

        workoutRecycler = findViewById(R.id.workout_items);


        workoutsList = new ArrayList<>();
        workoutsList.add(new Workouts("On a bar or assisted pullup machine," +
                " place your hands so they are each 6-8 inches beyond your shoulder width," +
                " fingers facing away from you. Inhale,then exhale as you pull your body up, " +
                "chin above the bar. Inhale as you lower down with control.", "Wide Grip Pull Ups",
                R.drawable.pullup, R.drawable.pullup));
        workoutsList.add(new Workouts("Set your feet hip-to-shoulder-width apart." +
                " Holding dumbbells above your shoulders, elbows bent and close to your sides," +
                " inhale as you sit back deeply while keeping your chest high, into a squat. " +
                "Exhale and press the floor away to come back to stand",
                "Dumbell Front Squats", R.drawable.squat, R.drawable.squat));
        workoutsList.add(new Workouts("Begin bending down by sending your hips back so" +
                " your torso is hinged at the waist; lightly bend your knees. Let the barbell hang " +
                "in front of your legs, fingers facing them, but don’t allow your shoulders to droop " +
                "forward. Inhale, then exhale as you row the barbell up,pulling your shoulder blades" +
                " together at the top. Slowly lower it back to start.",
                "Barbell Bentover Row", R.drawable.barbell, R.drawable.barbell));
        workoutsList.add(new Workouts("Sit on the floor with your back perpendicular to" +
                " a weight bench, and a barbell resting in your hip crease. Rest your shoulders " +
                "against the bench and bend your knees so your feet are on the floor. With your" +
                " hands holding the barbell in place, inhale, then exhale as you press your hips" +
                " toward the ceiling, such that your body from knees to shoulders forms a flat " +
                "tabletop position and your feet are flat on the ground directly below your knees." +
                " Inhale as you crease your hips to lower your butt back down.",
                "Barbell Hip Thrust", R.drawable.hip, R.drawable.hip));


        setWorkoutRecycler(workoutsList);


        exercise = new ArrayList<>();
        exercise.add(new Exercises("Deadlift Exercise",
                "Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps" +
                        " the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount" +
                        " of testosterone (a muscle-building hormone) " +
                        "into the bloodstream. For this reason, the deadlift is a great cornerstone for any fitness plan." +
                        "1 tablespoon green chilli sauce", "Method",
                "Deadlift Exercise\",\n" +
                        "Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                        "  the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                        "  of testosterone (a muscle-building hormone!\n", R.drawable.deadlift));

        exercise.add(new Exercises("Back Squat", "Deadlift Exercise\",\n" +
                "                \"Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "                        \" the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "                        \" of testosterone (a muscle-building hormone" +
                "Canola or vegetable oil, for frying", "Method", "\n" +
                "Deadlift Exercise,\n" +
                "  Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "    the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "   of testosterone (a muscle-building hormone!)", R.drawable.back));
        exercise.add(new Exercises("Bench Press", "Deadlift Exercise\",\n" +
                "   Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "   the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "  of testosterone (a muscle-building hormone"
                , "Method",
                "Deadlift Exercise\",\n" +
                        " Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                        "   the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                        "  of testosterone (a muscle-building hormone", R.drawable.bench));
        exercise.add(new Exercises("Dumbbell Romanian Deadlift", "Deadlift Exercise\",\n" +
                "        Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "         the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "         of testosterone (a muscle-building hormone", "Method",
                "Deadlift Exercise\",\n" +
                        "Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                        " the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                        " of testosterone (a muscle-building hormone.", R.drawable.dumbell));
        exercise.add(new Exercises("Kettlebell swing", "Deadlift Exercise\",\n" +
                "        Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "         the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "         of testosterone (a muscle-building hormone"
               , "Method",
                "Deadlift Exercise\",\n" +
                        "   Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                        "   the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                        "   of testosterone (a muscle-building hormone", R.drawable.kittlebell));


        myrecyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this, exercise);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        myrecyclerView.setAdapter(myAdapter);


    }


    private void setWorkoutRecycler(List<Workouts> workoutsDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        workoutRecycler.setLayoutManager(layoutManager);
        workoutsAdapter = new WorkoutsAdapter(this, workoutsDataList);
        workoutRecycler.setAdapter(workoutsAdapter);

    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable,3000);
    }
}
















