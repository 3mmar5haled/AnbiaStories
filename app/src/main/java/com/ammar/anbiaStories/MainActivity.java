package com.ammar.anbiaStories;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ammar.anbiaStories.databinding.ActivityMainBinding;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Glide.with(this).load(R.drawable.app_icon).circleCrop().into(binding.appIcon);


    }

    public void openDrawer(View view) {
        if (binding.drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            binding.drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            binding.drawerLayout.openDrawer(Gravity.RIGHT);
        }
    }

    public void openStories(View view) {
        startActivity(new Intent(this, StoriesActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    public void rateApp(View view) {
        String appPackageName = getPackageName();
        String appUrl = "https://play.google.com/store/apps/details?id=" + appPackageName;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(appUrl));
        startActivity(intent);
    }

    public void shareApp(View view) {
        String appPackageName = getPackageName();
        String appUrl = "https://play.google.com/store/apps/details?id=" + appPackageName;

        // Create the intent
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, check out this amazing app: " + appUrl);

        // Start the share intent
        startActivity(Intent.createChooser(shareIntent, "Share App Via"));
    }

    public void settings(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }
}