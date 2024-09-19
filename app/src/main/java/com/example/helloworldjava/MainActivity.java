package com.example.helloworldjava;

import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.helloworldjava.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    public boolean firstTimeOpening = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // add custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // setting up bottom nav bar navigation
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNav, navController);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });
    }
    // seemingly unnecessary if you include it in the XML
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent navIntent;
        if(item.getItemId()==R.id.aboutFragment){
            navIntent = new Intent(this, AboutActivity.class);
            Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            startActivity(navIntent, b);
        }
        else{
            navIntent = new Intent(this, SettingsActivity.class);
            Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            startActivity(navIntent, b);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        if(firstTimeOpening)
            firstTimeOpening= false;
        else
            Toast.makeText(this, "I see that you came back! :D", Toast.LENGTH_SHORT).show();

        super.onResume();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Ohh, you're leaving me alone? :(", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Make sure to pay me a visit, sometime soon...", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}