package org.spaceappchallenge.asteroidseeker.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.spaceappchallenge.asteroidseeker.JavaFXApp;
import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import org.springframework.context.ApplicationListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TopNEOTableStage implements ApplicationListener<JavaFXApp.StageReadyEvent> {

    @Override
    public void onApplicationEvent(JavaFXApp.StageReadyEvent event) {
        Stage stage = event.getStage();
        showStage(stage);
    }

    public void showStage(Stage stage) {
        TableView tableView = new TableView();
        tableView.setMinWidth(900);

        TableColumn<AsteroidResponseDTO, String> column1 =
                new TableColumn<>("Name of NEO");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("fullNameOfNEO"));


        TableColumn<AsteroidResponseDTO, String> column2 =
                new TableColumn<>("Orbit ID");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("orbitId"));

        TableColumn<AsteroidResponseDTO, String> column3 =
                new TableColumn<>("Designation Code");

        column3.setCellValueFactory(
                new PropertyValueFactory<>("designationCode"));

        TableColumn<AsteroidResponseDTO, String> column4 =
                new TableColumn<>("Diameter");

        column4.setCellValueFactory(
                new PropertyValueFactory<>("diameter"));

        TableColumn<AsteroidResponseDTO, String> column5 =
                new TableColumn<>("Distance");

        column5.setCellValueFactory(
                new PropertyValueFactory<>("distance"));

        TableColumn<AsteroidResponseDTO, String> column6 =
                new TableColumn<>("Time of Close Approach");

        column6.setCellValueFactory(
                new PropertyValueFactory<>("timeOfCloseApproach"));

        TableColumn<AsteroidResponseDTO, String> column7 =
                new TableColumn<>("Velocity");

        column7.setCellValueFactory(
                new PropertyValueFactory<>("velocity"));

        TableColumn<AsteroidResponseDTO, String> column8 =
                new TableColumn<>("Sigma");

        column8.setCellValueFactory(
                new PropertyValueFactory<>("sigma"));

        TableColumn<AsteroidResponseDTO, String> column9 =
                new TableColumn<>("Orbit Class");

        column9.setCellValueFactory(
                new PropertyValueFactory<>("orbitClass"));

        tableView.setEditable(false);
        tableView.setPlaceholder(new Label("No data to currently show."));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column8);
        tableView.getColumns().add(column9);

        List<AsteroidResponseDTO> listOfAsteroids = getListOfAsteroids();

        tableView.getItems().addAll(listOfAsteroids);

        tableView.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        tableView.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        VBox vbox = new VBox(tableView);
        Button backButton = new Button("Back");
        backButton.setOnMouseClicked(event -> {
            stage.hide();
            new StageInitializer().showStage(stage);
        });
        vbox.getChildren().add(backButton);

        Button otherObjects = new Button("Other Objects");
        otherObjects.setOnMouseClicked(event -> {
            stage.hide();
            new OtherNEOTableStage().showStage(stage);
        });
        vbox.getChildren().add(otherObjects);

        Scene scene = new Scene(vbox);

        stage.setScene(scene);

        stage.setTitle("Top Near Earth Object Threats");

        stage.show();
    }

    private List<AsteroidResponseDTO> getListOfAsteroids() {
        List<AsteroidResponseDTO> listOfAsteroids = new ArrayList<>();
        AsteroidResponseDTO asteroidResponseDTO = new AsteroidResponseDTO();
        asteroidResponseDTO.setOrbitId("dfjifdj");
        asteroidResponseDTO.setFullNameOfNEO("Apophis");
        asteroidResponseDTO.setVelocity(234);
        asteroidResponseDTO.setSigma("sigmaaa");
        asteroidResponseDTO.setDistance(343);
        asteroidResponseDTO.setOrbitClass("APO");
        asteroidResponseDTO.setDesignationCode("apoph");
        asteroidResponseDTO.setTimeOfCloseApproach(LocalDateTime.now().plusDays(100));
        asteroidResponseDTO.setDiameter(55);

        listOfAsteroids.add(asteroidResponseDTO);

        return listOfAsteroids;
    }

}
