package jat.vijesh.ecommerceapp.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
    private List<NavItems> itemsList = new ArrayList<>();

    public NavOptionFragment() {
        // Required empty public constructor
    }


    public void setSubItemOptions(List<NavItems> subItemsList) {
        itemsList.clear();
        itemsList.addAll(subItemsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_nav_option, container, false);

        navItemRecyclerView = view.findViewById(R.id.navItemRecyclerView);

        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initRecyclerView();

    }


    private void initRecyclerView() {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        navItemRecyclerView.setLayoutManager(linearLayoutManager);
        navItemRecyclerView.setHasFixedSize(true);
        mNavItemAdapter = new NavItemAdapter(getActivity(), itemsList, new NavItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, NavItems item) {


                if (item.getSubItems() != null && item.getSubItems().size() > 0) {

                    NavOptionFragment fragment = new NavOptionFragment();
                    fragment.setSubItemOptions(item.getSubItems());

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide1, R.anim.slide2)
                            .replace(R.id.navFragmentContainer, fragment)
                            .addToBackStack("fragment child")
                            .commit();


                } else {

                    Toast.makeText(getActivity(), " item Clicked - " + item.getName(), Toast.LENGTH_LONG).show();


                    navItemClickAction(item);

                }

            }
        });


        navItemRecyclerView.setAdapter(mNavItemAdapter);

    }

    private void navItemClickAction(NavItems item) {

        switch (item.getName()) {

            case "Home":

                HomeFragment fragment = new HomeFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide1, R.anim.slide2)
                        .add(R.id.navFragmentContainer, fragment).addToBackStack("HomeFragment")
                        .commit();

                break;

            case "Your Orders":

                addOrderFragment();

                break;






        }

    }


    private void addOrderFragment() {

        OrderFragment fragment = new OrderFragment();
        getActivity(). getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment).addToBackStack("OrderFragment")
                .commit();

    }

}
