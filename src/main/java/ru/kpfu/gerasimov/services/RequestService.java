package ru.kpfu.gerasimov.services;

import ru.kpfu.gerasimov.dto.RequestDto;
import ru.kpfu.gerasimov.model.Request;

import java.util.List;

public interface RequestService {
    List<RequestDto> findAllByUserId(int userId);

    List<RequestDto> findAllByCity(String city);
}
