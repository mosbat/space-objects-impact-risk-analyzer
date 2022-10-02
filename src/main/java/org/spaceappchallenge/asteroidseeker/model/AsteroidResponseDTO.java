package org.spaceappchallenge.asteroidseeker.model;

import java.time.LocalDateTime;

public class AsteroidResponseDTO {

    private String fullNameOfNEO;
    private String orbitId;
    private String designationCode;
    private double diameter;
    private double distance;
    private LocalDateTime timeOfCloseApproach;
    private double velocity;
    private String sigma;
    private String orbitClass;


    public void setFullNameOfNEO(String fullNameOfNEO) {
        this.fullNameOfNEO = fullNameOfNEO;
    }

    public void setOrbitId(String orbitId) {
        this.orbitId = orbitId;
    }

    public void setDesignationCode(String designationCode) {
        this.designationCode = designationCode;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTimeOfCloseApproach(LocalDateTime timeOfCloseApproach) {
        this.timeOfCloseApproach = timeOfCloseApproach;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setSigma(String sigma) {
        this.sigma = sigma;
    }

    public void setOrbitClass(String orbitClass) {
        this.orbitClass = orbitClass;
    }

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

    @Override
    public String toString() {
        return fullNameOfNEO + ", "
                + designationCode + ", "
                + orbitId + ", "
                + diameter + ", "
                + distance + ", "
                + timeOfCloseApproach + ", "
                + velocity + ", "
                + orbitClass + ", ";
    }
}
