package com.boniface.applytheme.app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.boniface.applytheme.R;
import com.boniface.applytheme.adapter.RecyclerAdapter;
import com.boniface.applytheme.model.Landscape;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        setUpDrawer();

        setupRecyclerView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setUpToolbar(){
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Navigation Drawer Demo");
        toolbar.inflateMenu(R.menu.menu_main);
    }

    private void setUpDrawer(){
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer_fragment);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerFragment.setUpDrawer(R.id.nav_drawer_fragment, drawerLayout, toolbar);

    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Landscape.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mlinearLayoutManagerVertical = new LinearLayoutManager(this);
        mlinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
