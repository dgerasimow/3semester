package ru.kpfu.gerasimov.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.kpfu.gerasimov.model.WeatherModel;

import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherModel, Integer> {
    @Query(value = "select * from weather w where w.city = ?1", nativeQuery = true)
    List<WeatherModel> getWeatherByCity(String city);
}
