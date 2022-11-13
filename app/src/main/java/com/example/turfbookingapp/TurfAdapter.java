package com.example.turfbookingapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TurfAdapter extends RecyclerView.Adapter<TurfAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<TurfModel> courseModelArrayList;

    // Constructor
    public TurfAdapter(Context context, ArrayList<TurfModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public TurfAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TurfAdapter.ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        TurfModel model = courseModelArrayList.get(position);
        holder.TurfNameTV.setText(model.getTurf_name());
        holder.TurfAreaTV.setText(model.getTurf_area());
        holder.TurfIV.setImageResource(model.getTurf_img());
        holder.TurfRating.setRating(model.getTurf_rating());
        holder.TurfPrice.setText(model.getTurf_price());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return courseModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView TurfIV;
        private final TextView TurfNameTV;
        private final TextView TurfAreaTV;
        private final RatingBar TurfRating;
        private final Button TurfPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TurfIV = itemView.findViewById(R.id.IVTurfImage);
            TurfNameTV = itemView.findViewById(R.id.TVTurfName);
            TurfAreaTV = itemView.findViewById(R.id.TVTurfArea);
            TurfRating = itemView.findViewById(R.id.ratingBar);
            TurfPrice = itemView.findViewById(R.id.btn_price);
        }
    }

}
