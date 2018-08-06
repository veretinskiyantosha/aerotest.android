package ru.aeroidea.aerotest.presentation.screens;

import java.io.Serializable;

import me.aartikov.alligator.Screen;

public class DetailScreen implements Screen, Serializable {
    private String mTitle;

    public DetailScreen(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }
}
