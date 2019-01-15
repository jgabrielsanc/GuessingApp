package com.android.diplomado.guessingapp.endpoints;

import android.util.Log;

import com.android.diplomado.guessingapp.models.Data;
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

 class TvShowController extends AbstractController {

    public static final String API_ENDPOINT = "https://www.episodate.com/api/";

    private List<Data> dataList = new ArrayList<>();


    @Override
    public List<Data> retrieveDataList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TvShow tvShow = retrofit.create(TvShow.class);

        Call<JsonObject> call = tvShow.getDataList();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                JsonObject jsonObject = response.body();
                for(JsonElement element : jsonObject.getAsJsonArray("tv_shows"))
                    dataList.add(new Data(element.getAsJsonObject().get("name").toString()));

                Log.i("Testing Value",dataList.toString());
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


    private interface TvShow {

        @GET("most-popular?page=1")
        Call<JsonObject> getDataList();
    }
}
