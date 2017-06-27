package sugar.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 2017/6/27.
 */

public class Weather {
    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    @SerializedName("suggestion")
    public Suggest suggest;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
