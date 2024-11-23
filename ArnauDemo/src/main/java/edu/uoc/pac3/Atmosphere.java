package edu.uoc.pac3;


import java.time.LocalDate;

public class Atmosphere {
    //define constant
    //Atmosphere.INVALID_COMPOSITION
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";

    //instance variable
    //Atmosphere atmosphere = new Atmosphere();   atmosphere.lastObservation
    private String composition;
    private LocalDate lastObservation;
    private int airQuality;
    private double pressure;
    private double density;
    private boolean hasClouds;

    //right click -> generate -> getters and setters / constructor / toString /etc...


    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    public String getComposition() {
        return composition;
    }

    private void setComposition(String composition) {
        //a lot of code here to make sure composition is valid
        String regex = "[A-Z]+[a-z]*\\d*[A-Z]*(, [A-Z]+[a-z]*\\d*[A-Z]*)*";
        if(composition == null || composition.isBlank() || !composition.matches(regex)){
            throw new IllegalArgumentException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }

    private void setLastObservation(LocalDate lastObservation) {
        LocalDate today = LocalDate.now();
        if (lastObservation == null || lastObservation.isAfter(today)) {
            throw new IllegalArgumentException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }

    private void setAirQuality(int airQuality) {
        if (airQuality < 0) {
            this.airQuality = 0;
        }else if(airQuality>100){
            this.airQuality = 100;
        }else {
            this.airQuality = airQuality;
        }
    }

    public double getPressure() {
        return pressure;
    }

    private void setPressure(double pressure) {
        if(pressure < 0){
            throw new IllegalArgumentException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }

    private void setDensity(double density) {
        if(density < 0){
            throw new IllegalArgumentException(INVALID_DENSITY);
        }
        this.density = density;
    }

    public boolean hasClouds() {
        return hasClouds;
    }

    private void setHasClouds(boolean hasClouds) {
        this.hasClouds = hasClouds;
    }


}
