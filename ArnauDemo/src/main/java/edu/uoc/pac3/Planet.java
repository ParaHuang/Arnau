package edu.uoc.pac3;

import java.time.LocalDate;

public class Planet {
    public static final String INVALID_NAME = "[ERROR] Name cannot be null or empty";
    public static final String INVALID_NUMBER_OF_MOONS = "[ERROR] Number of moons cannot be negative";
    public static final String INVALID_MASS = "[ERROR] Mass cannot be less than 10e23 kg";
    public static final String INVALID_RADIUS = "[ERROR] Radius cannot be less than 500 km";
    public static final String INVALID_GRAVITY = "[ERROR] Gravity cannot be negative or zero";
    public static final String INVALID_LAST_ALBEDO_MEASUREMENT = "[ERROR] Last albedo measurement cannot be null or in the future";
    private static final double MIN_MASS = 5.97e22;
    private static final double MIN_RADIUS = 500;
    private String name;
    private int numberOfMoons;
    private double mass;
    private double radius;
    private double gravity;
    private LocalDate lastAlbedoMeasurement;
    private boolean hasRings;
    private Atmosphere atmosphere;
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings) {
        this.name = name;
        this.numberOfMoons = numberOfMoons;
        this.mass = mass;
        this.radius = radius;
        this.gravity = gravity;
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
        this.hasRings = hasRings;
    }

    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings,
                  String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        this.name = name;
        this.numberOfMoons = numberOfMoons;
        this.mass = mass;
        this.radius = radius;
        this.gravity = gravity;
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
        this.hasRings = hasRings;
        atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    private void setNumberOfMoons(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }

    private void setMass(double mass) {
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    public double getGravity() {
        return gravity;
    }

    private void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }

    private void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
    }

    public boolean hasRings() {
        return hasRings;
    }

    private void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    private void setAtmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        this.atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }
}
