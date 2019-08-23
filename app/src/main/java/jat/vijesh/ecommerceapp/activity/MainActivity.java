package jat.vijesh.ecommerceapp.activity;

import android.arch.lifecycle.ReportFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import jat.vijesh.ecommerceapp.R;
import jat.vijesh.ecommerceapp.fragment.NavOptionFragment;
import jat.vijesh.ecommerceapp.model.NavItems;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout navFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navFragmentContainer = findViewById(R.id.navFragmentContainer);

        prepareNavItems();

        initNavItems();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private List<NavItems> itemsList = new ArrayList<>();

    private void prepareNavItems() {


        NavItems home = new NavItems();
        home.setName("Home");

        NavItems orders = new NavItems();
        orders.setName("Your Orders");

        NavItems mens = new NavItems();
        mens.setName("Mens");

        for (int i = 0; i < 6; i++) {
            NavItems items = new NavItems();
            items.setName("Mens Sub Item " + i);
            mens.getSubItems().add(items);
        }


        NavItems womens = new NavItems();
        womens.setName("Womens");

        for (int i = 0; i < 4; i++) {
            NavItems items = new NavItems();
            items.setName("Womens Sub Item " + i);
            womens.getSubItems().add(items);
        }

        NavItems kids = new NavItems();
        kids.setName("Kids");

        for (int i = 0; i < 6; i++) {
            NavItems items = new NavItems();
            items.setName("kids Sub Item " + i);


            if (i == 1 || i == 3){

                for (int j = 0; i < 4; i++) {


                    NavItems item = new NavItems();
                    item.setName("kids Sub Sub Items " + j);
                    items.getSubItems().add(item);



                }

            }



            kids.getSubItems().add(items);

        }


        NavItems settings = new NavItems();
        settings.setName("Settings");

        NavItems about = new NavItems();
        about.setName("About");


        itemsList.add(home);
        itemsList.add(orders);
        itemsList.add(mens);
        itemsList.add(womens);
        itemsList.add(kids);
        itemsList.add(settings);
        itemsList.add(about);


    }


    private void initNavItems() {

        NavOptionFragment fragment = new NavOptionFragment();
        fragment.setSubItemOptions(itemsList);
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide1, R.anim.slide2)
                .add(R.id.navFragmentContainer, fragment).addToBackStack("fragment")
                .commit();

    }

    @Override
    public void onBackPressed() {


        int count = getSupportFragmentManager().getBackStackEntryCount();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {

            if (count == 1)
                drawer.closeDrawer(GravityCompat.START);
            else {
                getSupportFragmentManager().popBackStack();
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
