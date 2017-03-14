package com.github.mzule.fantasyslide.domain;

import com.github.mzule.fantasyslide.domain.Weather;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanhong on 3/14/17.
 */

public class WeatherAPI {

    @SerializedName("HeWeather data service 3.0") @Expose
    public List<Weather> mHeWeatherDataService30s
            = new ArrayList<>();
}