package ru.mirea.kachalov.domain.repository;

public interface WeatherRepository {
    String getCurrentWeather(String location);

    String getWeatherForecast(String location);
}