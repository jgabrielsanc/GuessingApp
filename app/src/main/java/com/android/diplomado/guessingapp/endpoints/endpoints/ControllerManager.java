package com.android.diplomado.guessingapp.endpoints;

import com.android.diplomado.guessingapp.models.Data;

import java.util.List;

public class ControllerManager  {

    private static List<Data> dataList;
    private static  MovieController movieController;
    private static StarWarController starWarController;
    private static TvShowController tvShowController;
    private static CountryController countryController;
    private static AnimeController animeController;
    private static GameController gameController;


    public static List<Data> getCategoryData(int position) {

        switch (position) {

            case 0:

                if(movieController == null) {
                    movieController = new MovieController();
                    dataList =  movieController.retrieveDataList();
                }

                else
                    dataList = movieController.getDataList();

                break;

            case 1:

                if(starWarController == null) {
                    starWarController = new StarWarController();
                    dataList = starWarController.retrieveDataList();

                }

                else
                    dataList = starWarController.getDataList();

                break;

            case 2:

                if(tvShowController == null) {
                    tvShowController = new TvShowController();
                    dataList = tvShowController.retrieveDataList();
                }

                else
                    dataList = tvShowController.getDataList();

                break;

            case 3:
                   if(countryController == null) {
                       countryController = new CountryController();
                       dataList = countryController.retrieveDataList();
                   }

                   else
                       dataList = countryController.getDataList();

                   break;

            case 4:

                if(animeController == null) {
                    animeController = new AnimeController();
                    dataList = animeController.retrieveDataList();
                }

                else
                    dataList = animeController.getDataList();

                break;

            case 5:
                if(gameController == null) {
                    gameController = new GameController();
                    dataList = gameController.retrieveDataList();
                }

                else
                    dataList = gameController.getDataList();

        }

        return dataList;
    }




}
