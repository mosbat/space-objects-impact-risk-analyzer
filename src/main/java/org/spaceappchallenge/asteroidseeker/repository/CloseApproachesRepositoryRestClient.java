package org.spaceappchallenge.asteroidseeker.repository;

import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CloseApproachesRepositoryRestClient implements CloseApproachesRepository {

    @Override
    public AsteroidResponseDTO findById(String designationCode) {
        AsteroidResponseDTO responseDTO = new AsteroidResponseDTO();
        responseDTO.setFullNameOfNEO("Fake Asteroid");
        return responseDTO;
    }

    @Override
    public List<AsteroidResponseDTO> findAll(LocalDate dateFrom, LocalDate dateTo, double diameterMin, double diameterMax, double distanceMin, double distanceMax) {
        return null;
    }
}
