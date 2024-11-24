package edu.uoc.pac3;

import java.time.LocalDate;
import java.time.Period;

public class SolarSystem {
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, contain only spaces or have less than 3 characters";
    public static final String INVALID_NUMBER_OF_STARS = "[ERROR] Number of stars cannot be less than 1";
    public static final String INVALID_RADIUS = "[ERROR] Radius cannot be less or equal to 0";
    public static final String INVALID_REGISTRATION_DATE = "[ERROR] Registration date cannot be null or in the future";
    public static final String INVALID_LAST_PLANET_ADDED = "[ERROR] Last planet date added cannot be in the future";
    public static final String INVALID_MAX_PLANETS = "[ERROR] Maximum number of planets reached";
    public static final String PLANET_NULL = "[ERROR] Planet cannot be null";
    public static final String PLANET_ALREADY_EXISTS = "[ERROR] This planet already exists";
    public static final String PLANET_NOT_FOUND = "[ERROR] This planet does not exist";
    private static final int MIN_NAME_LENGTH = 3;
    private final int MAX_PLANETS;

    private int id;
    private static int nextId = 1;
    private String name;
    private int numberOfStars;
    private double radius;
    private LocalDate registrationDate;
    private LocalDate lastPlanetAdded;
    private int numPlanets;
    private int sumMoons;
    private Planet[] planets;

    public SolarSystem(String name, int numberOfStars, double radius, LocalDate registrationDate, int maxPlanets) {
        setName(name);
        setNumberOfStars(numberOfStars);
        setRadius(radius);
        setRegistrationDate(registrationDate);
        MAX_PLANETS = maxPlanets;
        planets = new Planet[MAX_PLANETS];
        numPlanets = 0;
        sumMoons = 0;
        setId();
        incNextId();
    }

    public int getMaxPlanets() {
        return MAX_PLANETS;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        this.id = nextId;
    }

    public static int getNextId() {
        return nextId;
    }

    private static void incNextId() {
        nextId++;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isBlank() || name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name.trim();
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    private void setNumberOfStars(int numberOfStars) {
        if (numberOfStars < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_STARS);
        }
        this.numberOfStars = numberOfStars;
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        if (radius <= 0) {
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

    public int getDaysFromLastPlanetAdded() {
        if(lastPlanetAdded == null)
            return -1;
        return Period.between(lastPlanetAdded,LocalDate.now()).getDays();
    }

    public int getNumPlanets() {
        int sum = 0;
        for(Planet p:planets){
            if(p != null){
                sum++;
            }
        }
        return sum;
    }
    private int findPlanet(Planet planet) {//find out the index of a planet
        if(planet == null){
            throw new IllegalArgumentException(PLANET_NULL);
        }
        for (int i = 0; i < planets.length; i++) {
            if(planet == planets[i]){
                return i;
            }
        }
        return -1;  //doesn't exist
    }
    private int findFirstEmptySlot(){//the first empty position
        for (int i = 0; i < planets.length; i++) {
            if(planets[i] == null){
                return i;
            }
        }
        return -1;//none of them is empty
    }
    public boolean containsPlanet(Planet planet) {
        return findPlanet(planet) != -1;
    }
    public void addPlanet(Planet planet,LocalDate addedDate){
        if(planet == null){
            throw new NullPointerException(PLANET_NULL);
        }
        LocalDate today = LocalDate.now();
        if (addedDate != null && addedDate.isAfter(today)) {
            throw new IllegalArgumentException(INVALID_LAST_PLANET_ADDED);
        }
        if(containsPlanet(planet)){
            throw new IllegalArgumentException(PLANET_ALREADY_EXISTS);
        }
        int index = findFirstEmptySlot();
        if(index == -1){
            throw new IllegalStateException(INVALID_MAX_PLANETS);
        }
        planets[index] = planet;
        sumMoons += planet.getNumberOfMoons();
        if(addedDate != null)
            lastPlanetAdded = addedDate;
    }
    public void removePlanet(Planet planet){//B
        if(planet == null){
            throw new IllegalArgumentException(PLANET_NULL);
        }
        int index = findPlanet(planet);
        if(index == -1){
            throw new IllegalArgumentException(PLANET_NOT_FOUND);
        }
        planets[index] = null;
    }
    public double getAverageMoonsByPlanet(){
//        System.out.println(sumMoons+"------"+getNumPlanets());
        return (double)sumMoons/getNumPlanets();
    }

}

//0     A
//1     B
//2     null
//3     C
//4     D
