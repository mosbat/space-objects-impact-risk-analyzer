package org.spaceappchallenge.asteroidseeker.service;

import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

public interface CloseApproachesService {

    Mono<List<AsteroidResponseDTO>> findById(String designationCode);
    List<AsteroidResponseDTO> findByDateRange(LocalDate dateFrom, LocalDate dateTo);
}
