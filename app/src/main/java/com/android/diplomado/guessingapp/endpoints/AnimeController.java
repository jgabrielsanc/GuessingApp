package com.android.diplomado.guessingapp.endpoints;

import android.util.JsonReader;
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


 class AnimeController extends AbstractController {


    public static final String API_ENDPOINT = "https://api.jikan.moe/v3/";

    private List<Data> dataList = new ArrayList<>();


    @Override
    public List<Data> retrieveDataList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Anime anime = retrofit.create(Anime.class);

        Call <JsonObject> call = anime.getDataList();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject json = response.body();
                JsonArray array =  json.get("top").getAsJsonArray();
                for(JsonElement jsonElement : array)
                dataList.add(new Data(jsonElement.getAsJsonObject().get("title").toString()));
                Log.i("Information",dataList.toString());

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





    private interface Anime  {

        @GET("top/anime/")
       Call<JsonObject> getDataList();

    }



}
