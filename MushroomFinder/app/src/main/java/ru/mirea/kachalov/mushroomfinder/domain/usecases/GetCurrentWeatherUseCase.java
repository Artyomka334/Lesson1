package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.repository.WeatherRepository;

public class GetCurrentWeatherUseCase {
    private final WeatherRepository weatherRepository;

    public GetCurrentWeatherUseCase(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public String execute(String location) {
        return weatherRepository.getCurrentWeather(location);
    }
}
