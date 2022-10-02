package org.spaceappchallenge.asteroidseeker;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.spaceappchallenge.asteroidseeker")
public class AsteroidseekerApplication {


	public static void main(String[] args) {
		Application.launch(JavaFXApp.class, args);
	}

}
