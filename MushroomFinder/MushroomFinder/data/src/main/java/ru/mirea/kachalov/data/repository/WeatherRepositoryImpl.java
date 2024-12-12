package ru.mirea.kachalov.data.repository;

import ru.mirea.kachalov.domain.repository.WeatherRepository;

public class WeatherRepositoryImpl implements WeatherRepository {

    @Override
    public String getCurrentWeather(String location) {
        return "Sunny, 25°C";
    }

    @Override
    public String getWeatherForecast(String location) {
        return "Rainy, 20°C";
    }
}
