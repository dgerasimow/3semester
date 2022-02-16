package ru.kpfu.gerasimov.respository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.gerasimov.model.WeatherModel;

public interface WeatherRepository extends CrudRepository<WeatherModel, Long> {
}
