package ru.kpfu.gerasimov.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.gerasimov.dto.RequestDto;
import ru.kpfu.gerasimov.repository.RequestRepository;
import ru.kpfu.gerasimov.services.RequestService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<RequestDto> findAllByUserId(int userId) {
        return requestRepository.findAllByUserId(userId).stream()
                .map(RequestDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<RequestDto> findAllByCity(String city) {
        return requestRepository.findAllByCity(city).stream()
                .map(RequestDto::fromModel)
                .collect(Collectors.toList());
    }
}
