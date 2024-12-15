package edu.uoc.pac4.activity;

public class ActivityProgrammingPython extends ActivityProgramming{

    private String pythonVersion;
    private boolean usesVirtualEnv;

    public ActivityProgrammingPython(String name, String description, double weight, String pythonVersion, boolean useVirtualEnv) throws ActivityException {
        super(name, description, weight);
        setPythonVersion(pythonVersion);
        setUsesVirtualEnv(useVirtualEnv);
    }

    @Override
    public String toString() {
        String str = "[Python] "+super.toString()+" ("+pythonVersion;
        if(usesVirtualEnv)
            str += ", with virtualenv)";
        return str;
    }

    public String getPythonVersion() {
        return pythonVersion;
    }


    public void setPythonVersion(String pythonVersion)  throws ActivityException {
        String regex = "\\d+([.]\\d+){1,2}";
        if(pythonVersion == null || pythonVersion.trim().isEmpty() || !pythonVersion.matches(regex))
            throw new ActivityException("[ERROR] Python version must be in the format x.y.z where z is optional");
        this.pythonVersion = pythonVersion;
    }

    public boolean getUsesVirtualEnv() {
        return usesVirtualEnv;
    }

    public void setUsesVirtualEnv(boolean usesVirtualEnv) {
        this.usesVirtualEnv = usesVirtualEnv;
    }
}
