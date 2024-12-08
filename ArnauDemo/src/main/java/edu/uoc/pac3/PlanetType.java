package edu.uoc.pac3;

public enum PlanetType {
    ROCKY("Rocky Planet",15,1000,300),
    GAS_GIANT("Gas Giant", 50, 3000, -150),
    ICE_GIANT("Ice Giant",40, 5000, -200);

    private final String description;
    private final double magneticFieldStrength;
    private final double averageDistanceFromStar;
    private final double averageTemperature;

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

    public static PlanetType getType(String description){
        for(PlanetType type:values()){
            if(type.getDescription().equals(description)){
                return type;
            }
        }
        return null;
    }

    public PlanetType getNextExpectedType(){
        PlanetType[] types = values();
        int currentIndex = this.ordinal();
        int nextIndex = (currentIndex + 1) % types.length;
        return types[nextIndex];
    }

}
