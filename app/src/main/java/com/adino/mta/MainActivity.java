package com.adino.mta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.adino.mta.models.Flame;
import com.adino.mta.glide.GlideApp;
import com.adino.mta.glide.GlidePreloadModelProvider;
import com.adino.mta.member.MembersActivity;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.util.FixedPreloadSizeProvider;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.adino.mta.util.Constants.IMAGE_HEIGHT_PIXELS;
import static com.adino.mta.util.Constants.IMAGE_WIDTH_PIXELS;
import static com.adino.mta.util.Constants.PRELOAD_AHEAD_ITEMS;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rv_flames;
    private RecyclerViewAdapter flameAdapter;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private static final String TAG = "MainActivity";

    private FirebaseRecyclerAdapter<Flame, FlameViewHolder> adapter;
    protected ArrayList<Object> flameObjs = new ArrayList<>();

    /**
     * Glide Image Loader
     */



    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("flames");

        //Glide preloading
        /*ListPreloader.PreloadSizeProvider sizeProvider =
                new FixedPreloadSizeProvider(IMAGE_WIDTH_PIXELS, IMAGE_HEIGHT_PIXELS);
        GlidePreloadModelProvider modelProvider = new GlidePreloadModelProvider(this, flameObjs);
        RecyclerViewPreloader<Flame> preloader = new RecyclerViewPreloader<>(
                GlideApp.with(this), modelProvider, sizeProvider, PRELOAD_AHEAD_ITEMS);*/

        // Instantiate RecyclerView
        rv_flames = (RecyclerView)findViewById(R.id.rv_flames);
        // Instantiate layout manager and add it to the RecyclerView
        rv_flames.setLayoutManager(new LinearLayoutManager(this));
        // Set up options for adapter
        Query query = databaseReference.limitToFirst(3);
        FirebaseRecyclerOptions<Flame> options = new FirebaseRecyclerOptions.Builder<Flame>()
                .setQuery(query, Flame.class)
                .build();
        //Use FirebaseRecyclerAdapter
        adapter = new FirebaseRecyclerAdapter<Flame, FlameViewHolder>(options) {
            @Override
            protected void onBindViewHolder(FlameViewHolder holder, int position, Flame model) {
                holder.bindViewHolder(model);
            }

            @Override
            public FlameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flame, parent, false);
                return new FlameViewHolder(view, MainActivity.this);
            }
        };

        //flameAdapter = new RecyclerViewAdapter(initialize(),this);

        rv_flames.setAdapter(adapter);

        // Add OnScrollListener
        //rv_flames.addOnScrollListener(preloader);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add new member", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent toMembersActivity = new Intent(MainActivity.this, MembersActivity.class);
                startActivity(toMembersActivity);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.stopListening();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
