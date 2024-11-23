package edu.uoc.pac3;

import java.time.LocalDate;

public class SolarSystem {
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, contain only spaces or have less than 3 characters";
    public static final String INVALID_NUMBER_OF_STARS = "[ERROR] Number of stars cannot be less than 1";
    public static final String INVALID_RADIUS = "[ERROR] Radius cannot be less or equal to 0";
    public static final String INVALID_REGISTRATION_DATE = "[ERROR] Registration date cannot be null or in the future";
    public static final String INVALID_LAST_PLANET_ADDED = "[ERROR] Last planet date added cannot be in the future";
    public static final String INVALID_MAX_PLANETS = "[ERROR] Maximum number of planets reached";
    public static final String PLANET_NULL = "[ERROR] Planet cannot be null";
    public static final String PLANET_ALREADY_EXISTS = "[ERROR] This planet already _exists";
    public static final String PLANET_NOT_FOUND = "[ERROR] This planet does not exist";
    private static final int MIN_NAME_LENGTH = 3;
    private final int MAX_PLANETS;

    private int id;
    private int nextId = 1;
    private String name;
    private int numberOfStars;
    private double radius;
    private LocalDate registrationDate;
    private LocalDate lastPlanetAdded;
    private int numPlanets;
    private int sumMoons;
    private Planet[] planets;

    public SolarSystem(String name, int numberOfStars, double radius, LocalDate registrationDate, int maxPlanets) {
        this.name = name;
        this.numberOfStars = numberOfStars;
        this.radius = radius;
        this.registrationDate = registrationDate;
        MAX_PLANETS = maxPlanets;
        planets = new Planet[MAX_PLANETS];
        numPlanets = 0;
        sumMoons = 0;
    }

    public int getMaxPlanets() {
        return MAX_PLANETS;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getNextId() {
        return nextId;
    }

    private void incNextId() {
        this.nextId++;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.isBlank() || name.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    private void setNumberOfStars(int numberOfStars) {
        if(numberOfStars < 1){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_STARS);
        }
        this.numberOfStars = numberOfStars;
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        if(radius <= 0){
            throw new IllegalArgumentException(INVALID_RADIUS);
        }
        this.radius = radius;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    private void setRegistrationDate(LocalDate registrationDate) {
        LocalDate today = LocalDate.now();
        if (registrationDate == null || registrationDate.isAfter(today)) {
            throw new IllegalArgumentException(INVALID_REGISTRATION_DATE);
        }
        this.registrationDate = registrationDate;
    }

    public LocalDate getLastPlanetAdded() {
        return lastPlanetAdded;
    }

    private void setLastPlanetAdded(LocalDate lastPlanetAdded) {
        LocalDate today = LocalDate.now();
        if (lastPlanetAdded.isAfter(today)) {
            throw new IllegalArgumentException(INVALID_LAST_PLANET_ADDED);
        }
        this.lastPlanetAdded = lastPlanetAdded;
    }

    public Planet[] getPlanets() {
        return planets;
    }

    public int getDaysFromLastPlanetAdded(){
//        return today - lastDay;
        return 0;
    }
}
