package jat.vijesh.ecommerceapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jat.vijesh.ecommerceapp.R;
import jat.vijesh.ecommerceapp.model.NavItems;

public class NavItemAdapter extends RecyclerView.Adapter<NavItemAdapter.MyViewHolder> {

    private Context context;
    private List<NavItems> mDataArray = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public NavItemAdapter(Context context, List<NavItems> mDataArray, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.mDataArray = mDataArray;
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClickListener(int position, NavItems item);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView navItemName;
        private View view;
        private ImageView navRightArrow, navItemIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            navItemName = itemView.findViewById(R.id.navItemName);
            navRightArrow = itemView.findViewById(R.id.navRightArrow);
            navItemIcon = itemView.findViewById(R.id.navItemIcon);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nav_item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        final NavItems item = mDataArray.get(position);

        if (item.getSubItems() != null && item.getSubItems().size() > 0) {
            holder.navRightArrow.setVisibility(View.VISIBLE);
        } else {
            holder.navRightArrow.setVisibility(View.GONE);
        }

        holder.navItemName.setText(item.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClickListener(position, item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataArray.size();
    }
}