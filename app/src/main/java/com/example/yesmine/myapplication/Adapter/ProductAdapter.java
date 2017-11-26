package com.example.yesmine.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yesmine.myapplication.Model.Produit;
import com.example.yesmine.myapplication.R;
import com.example.yesmine.myapplication.UI.ProductDetailsActivity;

import java.util.List;

import static com.example.yesmine.myapplication.UI.ProductDetailsActivity.VIEW_NAME_HEADER_IMAGE;
import static com.example.yesmine.myapplication.UI.ProductDetailsActivity.VIEW_NAME_HEADER_TITLE;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Produit> produits;
    private Context context;

    public ProductAdapter(List<Produit> getProduit,Context context) {
        super();
        this.produits = getProduit;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        Produit produitOBJ = produits.get(position);
        Viewholder.ProductTitileView.setText(produitOBJ.getTitle());
        Viewholder.InsurenceNameView.setText(produitOBJ.getAssurance().getName());

        try {
            byte[] decodedString = Base64.decode(produitOBJ.getImage(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            Viewholder.ProductImageView.setImageBitmap(decodedByte);
        }   catch (Exception e) {
            System.out.println("Exception ==>" + e);
        }
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView ProductTitileView;
        private TextView InsurenceNameView;
        private ImageView ProductImageView;


        private ViewHolder(final View itemView) {
            super(itemView);

            ProductTitileView = (TextView) itemView.findViewById(R.id.productTitleView);
            InsurenceNameView = (TextView) itemView.findViewById(R.id.InsurenceNameView);
            ProductImageView = (ImageView) itemView.findViewById(R.id.productImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Produit produit = produits.get(getAdapterPosition());
                    Intent intent = new Intent(context, ProductDetailsActivity.class);
                    intent.putExtra("produit",produit);

                    ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            (Activity) context,
                            // Now we provide a list of Pair items which contain the view we can transitioning
                            // from, and the name of the view it is transitioning to, in the launched activity
                            new Pair<View, String>(view.findViewById(R.id.productImageView),VIEW_NAME_HEADER_IMAGE),
                            new Pair<View, String>(view.findViewById(R.id.productTitleView),VIEW_NAME_HEADER_TITLE));

                    // Now we can start the Activity, providing the activity options as a bundle
                    ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
                }
            });
        }
    }
}
