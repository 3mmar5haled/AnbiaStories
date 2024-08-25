package com.ammar.anbiaStories;

import android.graphics.Bitmap;

import androidx.room.Entity;

import java.util.ArrayList;

@Entity(tableName = "stories")
public class Story {


    private String name;
    //private ArrayList types;

    public Story(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    interface Listener {
        void onClick(int position);
    }

}
