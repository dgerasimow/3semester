package ru.kpfu.gerasimov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.gerasimov.model.Request;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {
    @Query(value = "select * from requests r where r.user_id = ?1", nativeQuery = true)
    List<Request> findAllByUserId(int userId);

    @Query(value = "select * from requests r join weather w on w.id = r.weather_id where w.city = ?1", nativeQuery = true)
    List<Request> findAllByCity(String city);
}
