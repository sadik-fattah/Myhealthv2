package com.guercifzone.myhealthv2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.guercifzone.myhealthv2.Models.ProductData;
import com.guercifzone.myhealthv2.R;

import java.util.List;

public class AdapterRecyclerview extends RecyclerView.Adapter<AdapterRecyclerview.MyViewHolder> {

    private Context mcontext;
    private List<ProductData> feedlist;
    RequestOptions options;

    public AdapterRecyclerview(Context mcontext, List<ProductData> feedlist) {
        this.mcontext = mcontext;
        this.feedlist = feedlist;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background);;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        view = inflater.inflate(R.layout.product_item,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
     /*   viewHolder.contener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, Comic_details.class);
                intent.putExtra("comic_name",feedlist.get(viewHolder.getAdapterPosition()).getName());
                intent.putExtra("comic_link",feedlist.get(viewHolder.getAdapterPosition()).getLink());
                intent.putExtra("comic_type",feedlist.get(viewHolder.getAdapterPosition()).getType());
                intent.putExtra("comic_description",feedlist.get(viewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("comic_thumbnail",feedlist.get(viewHolder.getAdapterPosition()).getThumbnail());
                mcontext.startActivity(intent);
            }
        });*/
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.product_name.setText(feedlist.get(position).getProduct_name());
        holder.barcode.setText(feedlist.get(position).getBarcode());
        holder.ingredients_text.setText(feedlist.get(position).getIngredients_text());
        Glide.with(mcontext).load(feedlist.get(position).getImage_url()).apply(options).into(holder.product_image);

    }

    @Override
    public int getItemCount() {
        return feedlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
TextView product_name, barcode, ingredients_text;
ImageView product_image;
LinearLayout contener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name = itemView.findViewById(R.id.productName);
            barcode = itemView.findViewById(R.id.productBarcode);
            ingredients_text = itemView.findViewById(R.id.productIngredients);
            product_image = itemView.findViewById(R.id.productImage);
            contener = itemView.findViewById(R.id.container);
        }
    }
}
