package fiek.unipr.stayfit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.adapters.FoodsListAdapter;
import fiek.unipr.stayfit.models.FoodsModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link foodsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class foodsFragment extends Fragment {
    TextView foodName;
    TextView foodTag;
    ImageView foodImageUrl;
    TextView foodNutrition;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public foodsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment foodsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static foodsFragment newInstance(String param1, String param2) {
        foodsFragment fragment = new foodsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<FoodsModel> foodsModelList = getFoodsData();
        //initRecyclerView(foodsModelList);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foods, container, false);
        // Inflate the layout for this fragment
        List<FoodsModel> foodsModelList = getFoodsData();
        RecyclerView recyclerView =  view.findViewById(R.id.foodRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);
        FoodsListAdapter adapter = new FoodsListAdapter(foodsModelList);
        recyclerView.setAdapter(adapter);
        //initRecyclerView(foodsModelList, view);

        return view;

    }
/*    void initRecyclerView(List<FoodsModel> foodsModelList){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
    }*/
private void initRecyclerView(List<FoodsModel> foodsModelList, View view ) {
    RecyclerView recyclerView =  view.findViewById(R.id.foodRecyclerView);
    //recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    //recyclerView.setHasFixedSize(true);
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