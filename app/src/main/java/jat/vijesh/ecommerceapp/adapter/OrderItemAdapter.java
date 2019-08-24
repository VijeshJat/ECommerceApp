package jat.vijesh.ecommerceapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.MyViewHolder> {

    private Context context;
    private List<MayntraModel> mDataArray = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public OrderItemAdapter(Context context, List<MayntraModel> mDataArray, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.mDataArray = mDataArray;
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClickListener(int position, NavItems item);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtProductInfo, txtProductTitle;
        private View view;
        private FrameLayout mediaContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtProductInfo = itemView.findViewById(R.id.txtProductInfo);
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
            mediaContainer = itemView.findViewById(R.id.mediaContainer);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        MayntraModel item = mDataArray.get(position);

        holder.txtProductTitle.setText(item.getBrandsFilterFacet());
        holder.txtProductInfo.setText(item.getProductAdditionalInfo());


        List<MayntraModel.Image> mediaList = item.getImageMedia();

        if (mediaList != null) {

            if (mediaList.size() == 1) {


                drawViewForSingleMedia(holder, mediaList);


            } else if (mediaList.size() == 2) {

                drawViewForTwoMedia(holder, mediaList);

            } else if (mediaList.size() > 2) {

                drawViewForMultipleMedia(holder, mediaList);

                //
            } else {

            }
        }

    }

    private void drawViewForSingleMedia(final MyViewHolder holder, List<MayntraModel.Image> mediaList) {

        View view = LayoutInflater.from(context).inflate(R.layout.one_media_view, null, false);
        holder.mediaContainer.addView(view);

        ImageView image = view.findViewById(R.id.imageView);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        loadImage(mediaList.get(0).getPath(), image, progressBar);

    }


    private void loadImage(String imageUrl, ImageView imageView, final ProgressBar progressBar) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(context)
                .load(imageUrl)
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);

    }


    private void drawViewForTwoMedia(MyViewHolder holder, List<MayntraModel.Image> mediaList) {

        View view = LayoutInflater.from(context).inflate(R.layout.two_media_view, null, false);
        holder.mediaContainer.addView(view);

        ImageView image = view.findViewById(R.id.imageView);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        ImageView imageTwo = view.findViewById(R.id.imageViewTwo);
        ProgressBar progressBarTwo = view.findViewById(R.id.progressBarTwo);

        loadImage(mediaList.get(0).getPath(), image, progressBar);
        loadImage(mediaList.get(1).getPath(), imageTwo, progressBarTwo);

    }


    private void drawViewForMultipleMedia(MyViewHolder holder, List<MayntraModel.Image> mediaList) {

        View view = LayoutInflater.from(context).inflate(R.layout.more_media_view, null, false);
        holder.mediaContainer.addView(view);

        ImageView image = view.findViewById(R.id.imageView);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        ImageView imageTwo = view.findViewById(R.id.imageViewTwo);
        ProgressBar progressBarTwo = view.findViewById(R.id.progressBarTwo);
        TextView txtMediaCounter = view.findViewById(R.id.txtMediaCounter);

        loadImage(mediaList.get(0).getPath(), image, progressBar);
        loadImage(mediaList.get(1).getPath(), imageTwo, progressBarTwo);

        int counter = mediaList.size() - 2;
        txtMediaCounter.setText(counter + "+");
    }

    @Override
    public int getItemCount() {
        return mDataArray.size();
    }
}