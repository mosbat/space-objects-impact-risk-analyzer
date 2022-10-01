package org.spaceappchallenge.asteroidseeker;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXApp extends Application {
    @Override
    public void start(Stage primaryStage) {

        Group group = new Group();
        StackPane pane = new StackPane();
        group.getChildren().add(pane);
//Setting the title to Stage
        primaryStage.setTitle("Sample application");
        Scene scene = new Scene(group, 600, 300);
//Setting the scene to Stage
        primaryStage.setScene(scene);

//Displaying the stage
        primaryStage.show();
    }

    public static void runJavaFX(String[] args) {
        launch(args);
    }
}
