package sugar.coolweather.gson;

/**
 * Created by admin on 2017/6/27.
 */

public class AQI {
    public AQICity city;

    public class AQICity {

        public String aqi;

        public String pm25;
    }
}
