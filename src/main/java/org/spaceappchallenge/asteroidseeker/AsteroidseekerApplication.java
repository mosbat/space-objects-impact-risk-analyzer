package org.spaceappchallenge.asteroidseeker;

import javafx.application.Application;
import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import org.spaceappchallenge.asteroidseeker.service.CloseApproachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.spaceappchallenge.asteroidseeker")
public class AsteroidseekerApplication {


	public static void main(String[] args) {
		Application.launch(JavaFXApp.class, args);
	}

}
