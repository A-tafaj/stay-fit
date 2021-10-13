package fiek.unipr.stayfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.adapters.FoodsListAdapter;
import fiek.unipr.stayfit.models.FoodsModel;

public class foodsFragment extends Fragment {


    public foodsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foods, container, false);

        List<FoodsModel> foodsModelList = getFoodsData();

        initRecyclerView(foodsModelList, view);

        return view;
    }

    private void initRecyclerView(List<FoodsModel> foodsModelList, View view) {
        RecyclerView recyclerView = view.findViewById(R.id.foodRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);

        FoodsListAdapter adapter = new FoodsListAdapter(foodsModelList);
        recyclerView.setAdapter(adapter);
    }

    List<FoodsModel> getFoodsData() {
        InputStream inputStream = getResources().openRawResource(R.raw.food);
        Writer writer = new StringWriter();
        char[] buffer = new char[2056];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = writer.toString();
        Gson gson = new Gson();
        FoodsModel[] foodsModels = gson.fromJson(jsonString, FoodsModel[].class);
        List<FoodsModel> foodsModelList = Arrays.asList(foodsModels);
        return foodsModelList;
    }
}