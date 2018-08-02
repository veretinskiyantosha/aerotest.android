package ru.aeroidea.aerotest.presentation.screens;

import java.io.Serializable;

import me.aartikov.alligator.Screen;

public class TabScreen implements Screen, Serializable {
    private Screen mInnerScreen;

    public TabScreen(Screen innerScreen) {
        mInnerScreen = innerScreen;
    }

    public Screen getInnerScreen() {
        return mInnerScreen;
    }
}
