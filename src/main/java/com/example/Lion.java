package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Feline feline;

    public Lion(boolean isMale, Feline feline){
        this.hasMane = isMale;
        this.feline = feline;
    }


    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
