package ru.mirea.kachalov.mushroomfinder.domain.repository;

public interface WeatherRepository {
    String getCurrentWeather(String location);

    String getWeatherForecast(String location);
}