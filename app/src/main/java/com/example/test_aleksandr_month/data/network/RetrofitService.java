package com.example.test_aleksandr_month.data.network;

import com.example.test_aleksandr_month.data.entity.weather.CurrentWeatherEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET(ApiEndPoint.CURRENT_WEATHER)
    Call<CurrentWeatherEntity> getCurrentWeather(
            @Query("q") String city,
            @Query("appid") String appId  ,
            @Query("units") String metric
            );


}
