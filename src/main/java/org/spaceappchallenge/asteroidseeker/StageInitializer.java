package org.spaceappchallenge.asteroidseeker;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.spaceappchallenge.asteroidseeker.JavaFXApp.StageReadyEvent;
import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import org.spaceappchallenge.asteroidseeker.service.CloseApproachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Autowired
    CloseApproachesService closeApproachesService; // probably not the best place to inject this service

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        showStage(stage);
    }

    private void showStage(Stage stage) {
        // Mousa's code
        Group group = new Group();
        StackPane pane = new StackPane();
        group.getChildren().add(pane);
//Setting the title to Stage
        stage.setTitle("Sample application");
        Scene scene = new Scene(group, 600, 300);
//Setting the scene to Stage
        stage.setScene(scene);

//Displaying the stage
        stage.show();

        // remove this, only for checking if beans are being injected
        AsteroidResponseDTO res = closeApproachesService.findById("Any");
        System.out.println("ASTEROID: " + res.getFullNameOfNEO());
    }
}
