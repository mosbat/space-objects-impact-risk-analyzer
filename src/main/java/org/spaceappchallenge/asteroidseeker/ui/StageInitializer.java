package org.spaceappchallenge.asteroidseeker.ui;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.spaceappchallenge.asteroidseeker.JavaFXApp.StageReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        showStage(stage);
    }

    void showStage(Stage stage) {
        // Mousa's code
        Group group = new Group();
        GridPane pane = new GridPane();
        Label intro = new Label("Welcome to the Asteroids' Seeker. This tool will enable you to see details about the most up to date data related to near earth objects.");
        intro.setWrapText(true);
        intro.setAlignment(Pos.CENTER_LEFT);
        pane.add(intro, 0, 0);


        Button selectTopNearest = new Button("Top Near Earth Objects");
        selectTopNearest.setOnMouseClicked(event -> {
            stage.hide();
            new TopNEOTableStage().showStage(stage);
        });
        pane.add(selectTopNearest, 0, 1);

        Button otherNearEarthObjects = new Button("Other Objects");
        otherNearEarthObjects.setOnMouseClicked(event -> {
            stage.hide();
            new OtherNEOTableStage().showStage(stage);
        });

        pane.add(otherNearEarthObjects, 0, 2);

        group.getChildren().add(pane);
//Setting the title to Stage
        stage.setTitle("Asteroids' Seeker");
        Scene scene = new Scene(group, 800, 300);
//Setting the scene to Stage
        stage.setScene(scene);

//Displaying the stage
        stage.show();

    }
}
