package org.spaceappchallenge.asteroidseeker.repository;

import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CloseApproachesRepositoryRestClient implements CloseApproachesRepository {

    @Override
    public AsteroidResponseDTO findById(String designationCode) {
        AsteroidResponseDTO responseDTO = new AsteroidResponseDTO();
        responseDTO.setFullNameOfNEO("Fake Asteroid");
responseDTO.setDiameter(105);
responseDTO.setDesignationCode("fdfd33");
responseDTO.setTimeOfCloseApproach(LocalDateTime.now().plusDays(1));
responseDTO.setDistance(55.99);
responseDTO.setOrbitClass("APO");
responseDTO.setSigma("3fdfffdf3cdfd");
responseDTO.setVelocity(500000);
responseDTO.setOrbitId("orbitiddd");

        return responseDTO;
    }

    @Override
    public List<AsteroidResponseDTO> findAll(LocalDate dateFrom, LocalDate dateTo, double diameterMin, double diameterMax, double distanceMin, double distanceMax) {
        return null;
    }
}
