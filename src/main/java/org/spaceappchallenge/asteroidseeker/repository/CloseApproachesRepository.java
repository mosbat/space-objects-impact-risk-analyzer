package org.spaceappchallenge.asteroidseeker.repository;

import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface CloseApproachesRepository {
    AsteroidResponseDTO findById(String designationCode);
    List<AsteroidResponseDTO> findAll(LocalDate dateFrom, LocalDate dateTo, double diameterMin, double diameterMax, double distanceMin, double distanceMax);
}
