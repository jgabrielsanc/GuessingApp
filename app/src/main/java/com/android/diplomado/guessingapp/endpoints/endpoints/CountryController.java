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

 class CountryController extends AbstractController {

    public static final String API_ENDPOINT = "https://restcountries.eu/rest/";

    private List<Data> dataList = new ArrayList<>();


    @Override
    public List<Data> retrieveDataList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Country country = retrofit.create(Country.class);

        Call<JsonArray> call = country.getDataList();
        call.enqueue(new Callback<JsonArray>() {

            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                JsonArray array = response.body();

                for(JsonElement element : array)
                    dataList.add(new Data(element.getAsJsonObject().get("name").toString()));



            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });

        return dataList;
    }

     public List<Data> getDataList() {
         if(dataList == null || dataList.isEmpty())
             retrieveDataList();


         return dataList;

     }

    private interface Country {
        @GET("v2/all")
        Call<JsonArray> getDataList();
    }
}
