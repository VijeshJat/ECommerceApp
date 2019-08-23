package jat.vijesh.ecommerceapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

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

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtProductInfo = itemView.findViewById(R.id.txtProductInfo);
            imageView = itemView.findViewById(R.id.imageView);
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        MayntraModel item = mDataArray.get(position);

        holder.txtProductTitle.setText(item.getBrandsFilterFacet());
        holder.txtProductInfo.setText(item.getProductAdditionalInfo());


        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(context)
                .load(item.getSearchImage())
                .apply(requestOptions)
                .into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return mDataArray.size();
    }
}