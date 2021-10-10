package fiek.unipr.stayfit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.models.FoodsModel;

public class FoodsListAdapter extends RecyclerView.Adapter<FoodsListAdapter.ViewHolder> {
//    private final Context context;
    private List<FoodsModel> foodsModelList = new ArrayList<>();
//
//    public FoodsListAdapter(Context context) {
//        this.context = context;
//    }
//
    public FoodsListAdapter(List<FoodsModel> foodsModelList){
        this.foodsModelList = foodsModelList;
    }

    public void setFoodsModelList(List<FoodsModel> foodsModelList) {
        this.foodsModelList = foodsModelList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //public TextView
        TextView foodName;
        TextView foodTag;
        ImageView foodImageUrl;
        TextView foodNutrition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            foodImageUrl = itemView.findViewById(R.id.thumbImage);
            foodTag = itemView.findViewById(R.id.tag);
            foodNutrition = itemView.findViewById(R.id.nutritions);
        }
    }

    @NonNull
    @Override
    public FoodsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodsListAdapter.ViewHolder holder, int position) {
        holder.foodName.setText(foodsModelList.get(position).getName());
        holder.foodTag.setText(foodsModelList.get(position).getTags());
        holder.foodNutrition.setText("Nutritions: " + foodsModelList.get(position).getNutritions());

        Glide.with(holder.foodImageUrl)
                .load(foodsModelList.get(position).getUrl())
                .into(holder.foodImageUrl);
    }

    @Override
    public int getItemCount() {
        return foodsModelList.size();
    }
}