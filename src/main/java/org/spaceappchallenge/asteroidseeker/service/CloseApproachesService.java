package org.spaceappchallenge.asteroidseeker.service;

import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface CloseApproachesService {

    AsteroidResponseDTO findById(String designationCode);
    List<AsteroidResponseDTO> findByDateRange(LocalDate dateFrom, LocalDate dateTo);
}
