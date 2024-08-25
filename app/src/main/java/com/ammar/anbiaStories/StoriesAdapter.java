package com.ammar.anbiaStories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ammar.anbiaStories.databinding.StoryItemBinding;

import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.ViewHolder> {

    private List<Story> stories;
    private Story.Listener listener;

    public StoriesAdapter(List<Story> stories, Story.Listener listener) {
        this.stories = stories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(StoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story story = stories.get(position);
        holder.binding.name.setText(story.getName());
        holder.binding.getRoot().setOnClickListener(view -> {listener.onClick(position);});
        //holder.binding.image.setImageBitmap(Helper.getBitmapFromAssets(holder.itemView.getContext(), story.getImage()));

    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final StoryItemBinding binding;
        ViewHolder (@NonNull StoryItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}
