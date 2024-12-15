package edu.uoc.pac4.activity;

public class ActivityProgrammingJava extends ActivityProgramming{
    private String jdkVersion;
    private String gradleVersion;

    public ActivityProgrammingJava(String name, String description, double weight, String jdkVersion, String gradleVersion) throws ActivityException {
        super(name, description, weight);
        setJdkVersion(jdkVersion);
        setGradleVersion(gradleVersion);
    }

    @Override
    public String toString() {
        return "[Java] "+super.toString()+" (jdk-"+jdkVersion+", gradle v"+gradleVersion+")";
    }

    public String getJdkVersion() {
        return jdkVersion;
    }

    public void setJdkVersion(String jdkVersion) throws ActivityException {
        String regex = "\\d+([.]\\d+){0,2}";
        if(jdkVersion == null || jdkVersion.trim().isEmpty() || !jdkVersion.matches(regex))
            throw new ActivityException("[ERROR] JDK version must be in the format x.y.z where y and z are optional");
        this.jdkVersion = jdkVersion;
    }

    public String getGradleVersion() {
        return gradleVersion;
    }

    public void setGradleVersion(String gradleVersion) throws ActivityException {
        String regex = "\\d+([.]\\d+){1,2}";
        if(gradleVersion == null || gradleVersion.trim().isEmpty() || !gradleVersion.matches(regex))
            throw new ActivityException("[ERROR] Gradle version must be in the format x.y.z where z is optional");
        this.gradleVersion = gradleVersion;
    }
}
