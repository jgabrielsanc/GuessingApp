package com.android.diplomado.guessingapp.models;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class Data  implements Serializable {

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
