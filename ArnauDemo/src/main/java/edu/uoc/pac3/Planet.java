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
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
    }

    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings,
                  String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        try {
            setAtmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
        }catch (IllegalArgumentException e){
            //something wrong with creating atmosphere,but we don't want it to affect creating a planet
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    private void setNumberOfMoons(int numberOfMoons) {
        if(numberOfMoons < 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_MOONS);
        }
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }

    private void setMass(double mass) {
        if(mass < MIN_MASS){
            throw new IllegalArgumentException(INVALID_MASS);
        }
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        if(radius < MIN_RADIUS){
            throw new IllegalArgumentException(INVALID_RADIUS);
        }
        this.radius = radius;
    }

    public double getGravity() {
        return gravity;
    }

    private void setGravity(double gravity) {
        if(gravity <= 0){
            throw new IllegalArgumentException(INVALID_GRAVITY);
        }
        this.gravity = gravity;
    }

    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }

    private void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        LocalDate today = LocalDate.now();
        if (lastAlbedoMeasurement == null || lastAlbedoMeasurement.isAfter(today)) {
            throw new IllegalArgumentException(INVALID_LAST_ALBEDO_MEASUREMENT);
        }
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
