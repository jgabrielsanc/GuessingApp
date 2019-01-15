package com.android.diplomado.guessingapp.models;

import java.util.List;

public class Data {

   public String name;

   public Data(String name) {
       this.name = name;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return name;
    }
}
