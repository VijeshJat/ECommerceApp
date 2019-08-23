package jat.vijesh.ecommerceapp.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import jat.vijesh.ecommerceapp.R;
import jat.vijesh.ecommerceapp.adapter.HomeItemAdapter;
import jat.vijesh.ecommerceapp.adapter.NavItemAdapter;
import jat.vijesh.ecommerceapp.model.MayntraModel;
import jat.vijesh.ecommerceapp.model.NavItems;
import jat.vijesh.ecommerceapp.webservice.WebServiceCallBack;
import jat.vijesh.ecommerceapp.webservice.WebServiceManager;

import static jat.vijesh.ecommerceapp.webservice.UrlManager.GET_MAYNTRA_ITEMS;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private List<MayntraModel> itemList = new ArrayList<>();
    private RecyclerView itemRecyclerView;
    private HomeItemAdapter mHomeItemAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        itemRecyclerView =   view.findViewById(R.id.itemRecyclerView);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        setUpRecyclerView();
        WebServiceManager.get(getActivity(), GET_MAYNTRA_ITEMS, new WebServiceCallBack() {
            @Override
            public void onSuccess(String serverResponce, String apiName) {


                try {
                    JSONObject responce = new JSONObject(serverResponce);

                    if (responce.getJSONObject("data") != null && responce.getJSONObject("data").getJSONObject("results") != null) {

                        JSONArray products = responce.getJSONObject("data").getJSONObject("results").getJSONArray("products");

                        for (int i = 0; i < products.length(); i++) {

                            try {

                                String jsonString = products.getJSONObject(i).toString();
                                MayntraModel mMayntraModel = new Gson().fromJson(jsonString, MayntraModel.class);
                                itemList.add(mMayntraModel);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        } // for


                        updateListAdapter();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //  data  results  products
            }

            @Override
            public void onFailure(Object object, String apiName) {

            }
        });

    }

    private void setUpRecyclerView() {

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),2);
        itemRecyclerView.setLayoutManager(mGridLayoutManager);
        itemRecyclerView.setHasFixedSize(true);


        mHomeItemAdapter = new HomeItemAdapter(getActivity(), itemList, new HomeItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, NavItems item) {

                Toast.makeText(getActivity(), " item Clicked - " + item.getName(), Toast.LENGTH_LONG).show();

            }
        });


        itemRecyclerView.setAdapter(mHomeItemAdapter);
    }

    private void updateListAdapter() {

        mHomeItemAdapter.notifyDataSetChanged();

    }
}
