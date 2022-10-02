package org.spaceappchallenge.asteroidseeker.ui;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.spaceappchallenge.asteroidseeker.JavaFXApp;
import org.spaceappchallenge.asteroidseeker.model.AsteroidResponseDTO;
import org.springframework.context.ApplicationListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OtherNEOTableStage implements ApplicationListener<JavaFXApp.StageReadyEvent> {

    private TableView tableView;


    private ComboBox<AsteroidResponseDTO> objectsDropBox;

    @Override
    public void onApplicationEvent(JavaFXApp.StageReadyEvent event) {
        Stage stage = event.getStage();
        showStage(stage);
    }

    public void showStage(Stage stage) {
        tableView = new TableView();
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
        tableView.setPlaceholder(new Label("No data toDatePicker currently show."));

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

        VBox vbox = new VBox();

        DatePicker fromDatePicker = new DatePicker();
        fromDatePicker.setPromptText("From");

        DatePicker toDatePicker = new DatePicker();
        toDatePicker.setPromptText("To");

        vbox.getChildren().add(new Label("Filter"));

        objectsDropBox =
                new ComboBox<>();

        objectsDropBox.setItems(FXCollections
                .observableArrayList(getListOfAsteroids()));

        objectsDropBox.setEditable(false);
        objectsDropBox.setPlaceholder(new Label("No Objects Found"));

        vbox.getChildren().add(objectsDropBox);

        vbox.getChildren().add(fromDatePicker);
        vbox.getChildren().add(toDatePicker);

        Button applyFilter = new Button("Apply Filter");

        applyFilter.setOnMouseClicked(event -> {

            applyFilterToTable(fromDatePicker.getValue(), toDatePicker.getValue(), objectsDropBox.getSelectionModel().getSelectedItem());

        });

        vbox.getChildren().add(applyFilter);

        vbox.getChildren().add(tableView);

        Button backButton = new Button("Back");
        backButton.setOnMouseClicked(event -> {

            stage.hide();
            new StageInitializer().showStage(stage);
        });
        vbox.getChildren().add(backButton);


        Scene scene = new Scene(vbox);

        stage.setScene(scene);

        stage.show();

        actionsPostStageShow();

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

    private void actionsPostStageShow() {
        objectsDropBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(AsteroidResponseDTO object) {
                return object.getFullNameOfNEO();
            }

            @Override
            public AsteroidResponseDTO fromString(String string) {
                return objectsDropBox.getValue();
            }
        });

    }

    private void applyFilterToTable(LocalDate from, LocalDate to, AsteroidResponseDTO asteroidResponseDTO) {

        if (from == null && to == null && asteroidResponseDTO == null) {
            return;
        }

        tableView.getItems().clear();

        List<AsteroidResponseDTO> result = new ArrayList<>();

        for (AsteroidResponseDTO dto : getListOfAsteroids()) {
            LocalDate dtoLocalDate = dto.getTimeOfCloseApproach().toLocalDate();

            if (from != null && dtoLocalDate.isBefore(from)) {
                continue;
            }

            if (to != null && dtoLocalDate.isAfter(to)) {
                continue;
            }

            if (asteroidResponseDTO != null && !dto.getDesignationCode().equalsIgnoreCase(asteroidResponseDTO.getDesignationCode())) {
                continue;
            }

            result.add(dto);
        }

        tableView.getItems().addAll(result);

    }
}
