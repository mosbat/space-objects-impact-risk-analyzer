package org.spaceappchallenge.asteroidseeker.model;

import java.time.LocalDateTime;

public class AsteroidResponseDTO {

    // TODO: change this file
    private String fullNameOfNEO;
    private String orbitId;
    private String designationCode;
    private double diameter;
    private double distance;
    private LocalDateTime timeOfCloseApproach;
    private double velocity;
    private String sigma;
    private String orbitClass;


    public String getFullNameOfNEO() {
        return fullNameOfNEO;
    }

    public String getOrbitId() {
        return orbitId;
    }

    public String getDesignationCode() {
        return designationCode;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getDistance() {
        return distance;
    }

    public LocalDateTime getTimeOfCloseApproach() {
        return timeOfCloseApproach;
    }

    public double getVelocity() {
        return velocity;
    }

    public String getOrbitClass() {
        return orbitClass;
    }

    public String getSigma() {
        return sigma;
    }
}
