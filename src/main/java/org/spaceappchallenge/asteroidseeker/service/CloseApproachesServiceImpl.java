package org.spaceappchallenge.asteroidseeker.service;

import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import org.spaceappchallenge.asteroidseeker.repository.CloseApproachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
public class CloseApproachesServiceImpl implements CloseApproachesService {

    @Autowired
    CloseApproachesRepository closeApproachesRepository;

    @Override
    public Mono<List<AsteroidResponseDTO>> findById(String designationCode) {
        return closeApproachesRepository.findById(designationCode);
    }

    @Override
    public List<AsteroidResponseDTO> findByDateRange(LocalDate dateFrom, LocalDate dateTo) {
        return null;
    }
}
