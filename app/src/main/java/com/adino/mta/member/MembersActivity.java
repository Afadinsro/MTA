package com.adino.mta.member;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.adino.mta.R;
import com.adino.mta.RecyclerViewAdapter;
import com.adino.mta.enums.Ministry;
import com.adino.mta.models.Member;

import java.util.ArrayList;
import java.util.Collections;

public class MembersActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rv_members;
    private RecyclerViewAdapter memberAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Object> memberObjs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv_members = (RecyclerView)findViewById(R.id.rv_members);
        linearLayoutManager = new LinearLayoutManager(this);
        rv_members.setLayoutManager(linearLayoutManager);
        //Add adapter
        memberAdapter = new RecyclerViewAdapter(initialize(), this);
        rv_members.setAdapter(memberAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        rv_members.addItemDecoration(dividerItemDecoration);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add new member", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        getMenuInflater().inflate(R.menu.members, menu);
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

    public ArrayList<Object> initialize(){
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("John Doe", Ministry.DANCING_STARS));
        members.add(new Member("Joe Boye", Ministry.DANCING_STARS));
        members.add(new Member("Kwasi Anderson", Ministry.DANCING_STARS));
        members.add(new Member("Arnold Nigga", Ministry.DANCING_STARS));
        members.add(new Member("Rose Okwei", Ministry.DANCING_STARS));
        members.add(new Member("Ama Ziggy", Ministry.DANCING_STARS));
        members.add(new Member("Kofi Sparrow", Ministry.DANCING_STARS));
        members.add(new Member("King Kong", Ministry.DANCING_STARS));
        members.add(new Member("Man Quist", Ministry.DANCING_STARS));
        members.add(new Member("Flo Rida", Ministry.DANCING_STARS));
        members.add(new Member("Big Brother", Ministry.DANCING_STARS));
        members.add(new Member("Charley Man", Ministry.DANCING_STARS));
        members.add(new Member("Nii Yalley", Ministry.DANCING_STARS));
        Collections.sort(members);

        ArrayList<Object> memberObjs = new ArrayList<>();


        for (Member member : members) {
            Collections.addAll(memberObjs,member);
        }
        return memberObjs;
    }
}
