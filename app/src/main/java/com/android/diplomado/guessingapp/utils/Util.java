package com.android.diplomado.guessingapp.utils;

import com.android.diplomado.guessingapp.models.Category;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Category> getDummyData(){
        return new ArrayList<Category>(){{
            add(new Category("Peliculas", "Adivina las peliculas", "https://as01.epimg.net/meristation/imagenes/2018/01/22/reportaje/1516604400_722996_1531823096_sumario_normal.jpg"));
            add(new Category("Star Wars", "Adivina los personaje de star wars", "https://img.europapress.es/fotoweb/fotonoticia_20180402130008_640.jpg"));
            add(new Category("Tv Shows", "Adivina las series", "https://studybreaks.com/wp-content/uploads/2018/02/4-1.jpg"));
            add(new Category("Paises", "Adivina los paises", "https://cdn.noticiaaldia.com/wp-content/uploads/2016/08/banderas.jpg"));
            add(new Category("Animes", "Adivina los animes", "https://i0.wp.com/culturageek.com.ar/wp-content/uploads/2017/03/Naruto_primera_parte_HD.png"));
        }};
    }
}
