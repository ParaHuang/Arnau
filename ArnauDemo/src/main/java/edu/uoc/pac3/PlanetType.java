package edu.uoc.pac3;

public enum PlanetType {
    ROCKY("Rocky Planet",15,1000,30),
    GAS_GIANT("Gas Giant", 50, 3000, -150),
    ICE_GIANT("Ice Giant",40, 5000, -200);

    private String description;
    private double magneticFieldStrength;
    private double averageDistanceFromStar;
    private double averageTemperature;

    PlanetType(String description,double magneticFieldStrength,double averageDistanceFromStar,double averageTemperature) {
        this.description = description;
        this.magneticFieldStrength = magneticFieldStrength;
        this.averageDistanceFromStar = averageDistanceFromStar;
        this.averageTemperature = averageTemperature;
    }

    public String getDescription() {
        return description;
    }

    public double getMagneticFieldStrength() {
        return magneticFieldStrength;
    }

    public double getAverageDistanceFromStar() {
        return averageDistanceFromStar;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    PlanetType getType(String description){
        for(PlanetType type:values()){
            if(type.getDescription().equals(description)){
                return type;
            }
        }
        return null;
    }

    PlanetType getNextExpectedType(){
        PlanetType[] types = values();
        int currentIndex = this.ordinal();
        int nextIndex = (currentIndex + 1) % types.length;
        return types[nextIndex];
    }
}
