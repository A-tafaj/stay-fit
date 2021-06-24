package fiek.unipr.stayfit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import fiek.unipr.stayfit.adapters.FoodsListAdapter;
import fiek.unipr.stayfit.model.FoodsModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link foodsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class foodsFragment extends Fragment implements FoodsListAdapter.FoodsListClickListener {

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
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();// hides from all the fragments

        List<FoodsModel> foodsModelList =  getFoodsData();

        initRecyclerView(foodsModelList);// // // // // / //--------------- qita te on create view

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_foods, container, false);
    }

    private List<FoodsModel> getFoodsData() {
        InputStream is = getResources().openRawResource(R.raw.food);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try{
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while(( n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0,n);
            }
        }catch (Exception e) {

        }

        String jsonStr = writer.toString();
        Gson gson = new Gson();
        FoodsModel[] foodsModels =  gson.fromJson(jsonStr, FoodsModel[].class);
        List<FoodsModel> foodsList = Arrays.asList(foodsModels);

        return  foodsList;

    }
    private void initRecyclerView(List<FoodsModel> foodsModelList ) {
        RecyclerView recyclerView =  getActivity().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));//getContext())
        /*use getActivity(), which returns the activity associated with a fragment.
The activity is a context (since Activity extends Context).*/
        FoodsListAdapter adapter = new FoodsListAdapter(foodsModelList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(FoodsModel foodsModel) {

    }
}