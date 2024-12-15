package edu.uoc.pac4.activity;

public class ActivityProgrammingCpp extends ActivityProgramming{
    private String compiler;
    private String standard;
    public ActivityProgrammingCpp(String name, String description, double weight, String compiler, String standard) throws ActivityException {
        super(name, description, weight);
        setCompiler(compiler);
        setStandard(standard);
    }

    public String getCompiler() {
        return compiler;
    }

    public void setCompiler(String compiler) throws ActivityException {
        if(compiler == null || compiler.trim().isEmpty())
            throw  new ActivityException("[ERROR] Compiler cannot be null, empty or blank");
        this.compiler = compiler.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) throws ActivityException {
        if(standard == null || standard.trim().isEmpty())
            throw  new ActivityException("[ERROR] Standard cannot be null, empty or blank");
        this.standard = standard.trim();
    }

    @Override
    public String toString() {
        return "[C++] "+super.toString()+" ("+compiler+", "+standard+")";
    }
}
