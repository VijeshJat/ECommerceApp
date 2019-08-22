package jat.vijesh.ecommerceapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jat.vijesh.ecommerceapp.R;
import jat.vijesh.ecommerceapp.adapter.NavItemAdapter;
import jat.vijesh.ecommerceapp.model.NavItems;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavOptionFragment extends Fragment {

    private View view;
    private RecyclerView navItemRecyclerView;
    private NavItemAdapter mNavItemAdapter;

    public NavOptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_nav_option, container, false);

        navItemRecyclerView = view.findViewById(R.id.navItemRecyclerView);


        prepareNavItems();
        initRecyclerView();

        return view;

    }

    private void prepareNavItems() {


        NavItems home = new NavItems();
        home.setName("Home");

        NavItems orders = new NavItems();
        orders.setName("Your Orders");

        NavItems itemOne = new NavItems();
        itemOne.setName("Home");

        NavItems mens = new NavItems();
        mens.setName("Mens");


        NavItems womens = new NavItems();
        womens.setName("Womens");


        NavItems kids = new NavItems();
        kids.setName("Kids");

        NavItems settings = new NavItems();
        settings.setName("Settings");

        NavItems about = new NavItems();
        about.setName("About");

    }

    private void initRecyclerView() {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        navItemRecyclerView.setLayoutManager(linearLayoutManager);
        navItemRecyclerView.setHasFixedSize(true);
        mNavItemAdapter = new NavItemAdapter(getActivity(), null, new NavItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, NavItems item) {

            }
        });


        navItemRecyclerView.setAdapter(mNavItemAdapter);

    }

}
