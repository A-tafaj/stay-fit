package fiek.unipr.stayfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.model.FoodsModel;

public class FoodsListAdapter extends RecyclerView.Adapter<FoodsListAdapter.MyViewHolder> {

    private List<FoodsModel> foodsModelList;
    private FoodsListClickListener clickListener;

    public FoodsListAdapter(List<FoodsModel> foodsModelList){
        this.foodsModelList = foodsModelList;
    }
    public FoodsListAdapter(List<FoodsModel> foodsModelList, FoodsListClickListener clickListener){//
        this.foodsModelList = foodsModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public FoodsListAdapter.MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull FoodsListAdapter.MyViewHolder holder, int position) {
        holder.foodsName.setText(foodsModelList.get(position).getName());
        holder.foodsTag.setText(foodsModelList.get(position).getTags());
        holder.foodNutrition.setText(foodsModelList.get(position).getNutritions().getSomeValues());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(foodsModelList.get(position));
            }
        });
        Glide.with(holder.thumbImage)
                .load(foodsModelList.get(position).getUrl())
                .into(holder.thumbImage);
    }

    @Override
    public int getItemCount() {
        return foodsModelList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView foodsName;
        TextView foodsTag;
        TextView foodNutrition;
        ImageView thumbImage;

        public MyViewHolder(View view){
            super(view);
            foodsName = view.findViewById(R.id.foodsName);
            foodsTag = view.findViewById(R.id.foodsTag);
            foodNutrition = view.findViewById(R.id.foodsNutrition);
            thumbImage = view.findViewById(R.id.thumbImage);
        }
    }
    public interface FoodsListClickListener{
        public void onItemClick(FoodsModel foodsModel);
    }
}
