package com.ammar.anbiaStories;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.ammar.anbiaStories.databinding.ActivityMainBinding;
import com.ammar.anbiaStories.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(v -> onBackPressed());


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}