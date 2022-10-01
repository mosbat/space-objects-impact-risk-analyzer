package org.spaceappchallenge.asteroidseeker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsteroidseekerApplication {

	public static void main(String[] args) {
		new Thread(() -> {
			try {
				JavaFXApp.runJavaFX(args);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).start();

		SpringApplication.run(AsteroidseekerApplication.class, args);
	}

}
