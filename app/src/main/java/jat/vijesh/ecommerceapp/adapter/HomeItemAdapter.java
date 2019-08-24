package jat.vijesh.ecommerceapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import jat.vijesh.ecommerceapp.R;
import jat.vijesh.ecommerceapp.model.MayntraModel;
import jat.vijesh.ecommerceapp.model.NavItems;

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.MyViewHolder> {

    private Context context;
    private List<MayntraModel> mDataArray = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public HomeItemAdapter(Context context, List<MayntraModel> mDataArray, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.mDataArray = mDataArray;
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClickListener(int position, NavItems item);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtProductInfo,txtProductTitle;
        private View view;
        private ImageView imageView;
        private ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtProductInfo = itemView.findViewById(R.id.txtProductInfo);
            imageView = itemView.findViewById(R.id.imageView);
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        MayntraModel item = mDataArray.get(position);

        holder.txtProductTitle.setText(item.getBrandsFilterFacet());
        holder.txtProductInfo.setText(item.getProductAdditionalInfo());


        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(context)
                .load(item.getSearchImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return mDataArray.size();
    }
}