package com.example.test_aleksandr_month.ui.skills;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test_aleksandr_month.R;
import com.example.test_aleksandr_month.data.entity.weather.CurrentWeatherEntity;
import com.example.test_aleksandr_month.data.entity.weather.MainEntity;
import com.example.test_aleksandr_month.data.entity.weather.WeatherEntity;
import com.example.test_aleksandr_month.data.network.RetrofitBuilder;
import com.example.test_aleksandr_month.ui.main.MainActivity;
import com.example.test_aleksandr_month.ui.skills.recyclerview.SkillsAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.test_aleksandr_month.BuildConfig.WEATHER_KEY;


public class SkillsFragment extends Fragment {

    RecyclerView recyclerView;
    SkillsAdapter adapter;
    private TextView tvDate;
    private TextView tvMonth;
    private ImageView imageMain;
    private TextView tvPressure;
    private TextView tvWind;
    CurrentWeatherEntity data;
    WeatherEntity weatherEntity;
    MainEntity main;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_skills);
        tvDate = view.findViewById(R.id.tvDate);
        tvMonth = view.findViewById(R.id.tvMonth);
        imageMain = view.findViewById(R.id.imageMain);
        tvPressure = view.findViewById(R.id.tvPressureNum);
        tvWind = view.findViewById(R.id.tvWindNum);

        SkillsAdapter adapter = new SkillsAdapter();
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RetrofitBuilder.getInstance().getCurrentWeather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<CurrentWeatherEntity>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(Call<CurrentWeatherEntity> call, Response<CurrentWeatherEntity> response) {
                        Log.d("ololo", "ololo");
                        data = response.body();
                        assert data != null;
                        tvDate.setText(data.getDt());
                        tvWind.setText(data.getWind().getSpeed() + "m/s");
                        tvPressure.setText(data.getMain().getPressure() + "m/b");

                        Glide.with(getActivity().getApplicationContext())
                                .load("http://openweathermap.org/img/wn/"
                                        + weatherEntity.getIcon() + "01d@2x.png")
                                .into(imageMain);

                        Log.d("data ", call.request().toString());

                    }

                    @Override
                    public void onFailure(Call<CurrentWeatherEntity> call, Throwable t) {
                        Log.d("ololo", "ololo");
                    }
                });
    }



    OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {

        }
    };
}
