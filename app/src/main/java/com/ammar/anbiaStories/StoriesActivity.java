package com.ammar.anbiaStories;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ammar.anbiaStories.databinding.ActivityStoriesBinding;

import java.util.ArrayList;

public class StoriesActivity extends AppCompatActivity {

    private ActivityStoriesBinding binding;

    private StoriesAdapter storiesAdapter;
    private ArrayList<Story> stories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(v -> onBackPressed());

        stories = new ArrayList<>();

        for (String[] row : Helper.readCSVFromAssets(this, "AnbiaNames.csv")) {
            stories.add(new Story(row[0]));
        }

        storiesAdapter = new StoriesAdapter(stories, (position) -> {});
        binding.stories.setAdapter(storiesAdapter);
        binding.stories.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}