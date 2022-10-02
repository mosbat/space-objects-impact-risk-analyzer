package org.spaceappchallenge.asteroidseeker.repository;

import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

public interface CloseApproachesRepository {
    Mono<List<AsteroidResponseDTO>> findById(String designationCode);
    List<AsteroidResponseDTO> findAll(LocalDate dateFrom, LocalDate dateTo, double diameterMin, double diameterMax, double distanceMin, double distanceMax);
}
