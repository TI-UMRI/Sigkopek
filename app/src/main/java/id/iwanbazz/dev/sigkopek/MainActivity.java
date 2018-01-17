package id.iwanbazz.dev.sigkopek;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import id.iwanbazz.dev.sigkopek.Fragment.GmapFragment;
import id.iwanbazz.dev.sigkopek.Fragment.HomeFragment;
import id.iwanbazz.dev.sigkopek.Fragment.KategoriFragment;
import id.iwanbazz.dev.sigkopek.Fragment.PencarianFragment;
import id.iwanbazz.dev.sigkopek.Fragment.PengaduanFragment;
import id.iwanbazz.dev.sigkopek.SubKategori.SubPemerintahan;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    FragmentTransaction nFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    // tombol back exit
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

        Fragment fragment = null;
        android.support.v4.app.FragmentManager sFm = getSupportFragmentManager();

        int id = item.getItemId();
        //  Bundle bundle = new Bundle();
        // sub menu
        switch (id){
            case R.id.home :
                fragment = new HomeFragment();
                break;
            case R.id.sub_pemerintahan:
                Intent in = new Intent(getApplicationContext(), SubPemerintahan.class);
                startActivity(in);
                break;
            case R.id.maps:
                fragment = new GmapFragment();
                break;
            case R.id.search :
                fragment = new PencarianFragment();

                break;
            //case R.id.pegaduan:
                //fragment = new PengaduanFragment();
                //Intent in = new Intent(getApplicationContext(), Pengaduan.class);
                //startActivity(in);
        }

        //  fragment.setArguments(bundle);


        //initToolbar();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_contain, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

      /*  if (id == R.id.pegaduan ) {
            Intent in = new Intent(MainActivity.this, Pengaduan.class);
            startActivity(in);
        }*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }

}
