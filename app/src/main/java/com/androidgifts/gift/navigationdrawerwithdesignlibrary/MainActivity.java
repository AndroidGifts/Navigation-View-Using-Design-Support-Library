package com.androidgifts.gift.navigationdrawerwithdesignlibrary;

import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolBar;
    private NavigationView navDrawer;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolBar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navDrawer = (NavigationView) findViewById(R.id.menu_drawer);
        navDrawer.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.setDrawerListener(drawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        drawerToggle.syncState();

        selectedItem = savedInstanceState == null ? R.id.nav_item_1 : savedInstanceState.getInt("selectedItem");
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        selectedItem = menuItem.getItemId();

        switch (selectedItem) {
            case R.id.nav_item_1:
                Toast.makeText(this, "Android is clicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_2:
                Toast.makeText(this, "Gift is clicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_3:
                Toast.makeText(this, "Delete is clicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_5:
                Toast.makeText(this, "Favorite is clicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_6:
                Toast.makeText(this, "Settings is clicked !", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    /**
     * Override onBackPressed method so that when a user clicks on it, it closes
     * the NavigationDrawer if it's opened not the App.
     */
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt("selectedItem", selectedItem);
    }
}
