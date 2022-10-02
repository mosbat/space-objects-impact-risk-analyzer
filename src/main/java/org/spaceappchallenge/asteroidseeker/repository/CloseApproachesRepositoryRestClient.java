package org.spaceappchallenge.asteroidseeker.repository;

import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import org.spaceappchallenge.asteroidseeker.model.CloseApproachResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CloseApproachesRepositoryRestClient implements CloseApproachesRepository {

    private final String API_BASE_URL = "https://ssd-api.jpl.nasa.gov";
    private final String API_URI = "/cad.api";
    private final String API_DEFAULT_PARAMS = "&diameter=true&fullname=true";
    private final String API_DEFAULT_DATE_RANGE = "&date-min=1900-01-01&date-max=2200-12-31";

    @Override
    public Mono<List<AsteroidResponseDTO>> findById(String designationCode) {

        WebClient client = WebClient.builder()
                .baseUrl(API_BASE_URL)
                .build();
        Mono<CloseApproachResponse> res = client.get()
                .uri(API_URI + "?des=" + designationCode + API_DEFAULT_PARAMS + API_DEFAULT_DATE_RANGE)
                .retrieve()
                .bodyToMono(CloseApproachResponse.class);
        CloseApproachResponse response = res.block();

        return Mono.just(mapToListOfResponseDTO(response));
    }

    @Override
    public List<AsteroidResponseDTO> findAll(LocalDate dateFrom, LocalDate dateTo, double diameterMin, double diameterMax, double distanceMin, double distanceMax) {
        return null;
    }

    private List<AsteroidResponseDTO> mapToListOfResponseDTO(CloseApproachResponse response) {
        List<AsteroidResponseDTO> asteroids = new ArrayList<>(response.getCount());
        for (int i=0; i< response.getCount(); i++) {
            AsteroidResponseDTO asteroid = new AsteroidResponseDTO();
            asteroid.setDesignationCode(response.getData().get(i)[0]);
            asteroid.setOrbitId(response.getData().get(i)[1]);
            asteroid.setTimeOfCloseApproach(LocalDateTime.now());//response.getData().get(i)[3]
            asteroid.setDistance(Double.parseDouble(response.getData().get(i)[4]));
            asteroid.setVelocity(Double.parseDouble(response.getData().get(i)[7]));
            asteroid.setSigma(response.getData().get(i)[9]);
            asteroid.setDiameter(Double.parseDouble(response.getData().get(i)[11]));
            asteroid.setFullNameOfNEO(response.getData().get(i)[13]);
            asteroids.add(asteroid);
        }
        return asteroids;
    }
}
