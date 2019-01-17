package com.android.diplomado.guessingapp.endpoints;

import android.util.Log;

import com.android.diplomado.guessingapp.models.Data;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

 class GameController extends AbstractController {

    public static final String API_ENDPOINT = "http://www.amiiboapi.com/api/";


    private List<Data> dataList = new ArrayList<>();

    @Override
    public List<Data> retrieveDataList() {

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Game game = retrofit.create(Game.class);
        Call<JsonObject> call = game.getDataList();
        call.enqueue(new Callback<JsonObject>() {

            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                JsonArray array = response.body().getAsJsonArray("amiibo");
                for(JsonElement element : array)
                    dataList.add(new Data(element.getAsJsonObject().get("name").toString()));

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

        return dataList;
    }


     public List<Data> getDataList() {
         if(dataList == null || dataList.isEmpty())
             retrieveDataList();

         return dataList;

     }

    private interface Game {

        @GET("gameseries")
        Call<JsonObject> getDataList();
    }
}