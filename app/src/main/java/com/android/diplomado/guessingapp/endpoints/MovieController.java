package com.android.diplomado.guessingapp.endpoints;

import com.android.diplomado.guessingapp.models.Data;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

  class MovieController  extends AbstractController {

    public static final String API_ENDPOINT = "https://hydramovies.com/";

    private  List<Data> dataList = new ArrayList<>();



    public  List<Data> retrieveDataList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Movie movie = retrofit.create(Movie.class);

        Call<JsonArray> call = movie.getDataList();
        call.enqueue(new Callback<JsonArray>() {

            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                JsonArray array = response.body().getAsJsonArray();

                for (JsonElement element : array) {
                    if(dataList.size() <= 50)
                        dataList.add(new Data(element.getAsJsonObject().get("fulltitle").toString()));
                    else
                        break;

                }

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });

        return dataList;
    }



    private interface Movie  {

        @GET("api-v2/?source=http://hydramovies.com/api-v2/current-Movie-Data.csv")
        Call<JsonArray> getDataList();
    }

    public List<Data> getDataList() {
        if(dataList == null || dataList.isEmpty())
            retrieveDataList();


        return dataList;

    }

}
