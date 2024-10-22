package ru.mirea.kachalov.domain.usecases;

import ru.mirea.kachalov.domain.repository.WeatherRepository;

public class GetWeatherForecastUseCase {
    private final WeatherRepository weatherRepository;

    public GetWeatherForecastUseCase(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public String execute(String location) {
        return weatherRepository.getWeatherForecast(location);
    }
}