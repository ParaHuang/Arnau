package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import edu.uoc.pac4.user.UserException;

import java.util.LinkedList;

public abstract class Activity implements Cloneable{
    private String name;
    private String description;
    private LinkedList<Execution> executions;

    public Activity(String name, String description) throws ActivityException {
        setName(name);
        setDescription(description);
        executions = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ActivityException {
        if (name == null || name.trim().isEmpty()){
            throw new ActivityException(ActivityException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null) description = "";
        this.description = description;
    }

    public void addExecution(Execution execution){
        executions.add(execution);
    }

    public LinkedList<Execution> getExecutions() {
        return executions;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        Activity activity = null;
        try {
            if(this.getClass() == ActivityQuiz.class) {
                ActivityQuiz quiz = (ActivityQuiz) this;
                return new ActivityQuiz(name,description,quiz.getType());
            }else if(this.getClass() == ActivityProgrammingCpp.class){
                ActivityProgrammingCpp cpp = (ActivityProgrammingCpp) this;
                return new ActivityProgrammingCpp(name,description,cpp.getWeight(),cpp.getCompiler(),cpp.getStandard());
            }else if(this.getClass() == ActivityProgrammingJava.class){
                ActivityProgrammingJava java = (ActivityProgrammingJava) this;
                return new ActivityProgrammingJava(name,description,java.getWeight(), java.getJdkVersion(), java.getGradleVersion());
            }else if(this.getClass() == ActivityProgrammingPython.class){
                ActivityProgrammingPython python = (ActivityProgrammingPython) this;
                return new ActivityProgrammingPython(name,description,python.getWeight(),python.getPythonVersion(),python.getUsesVirtualEnv());
            }
//            else if(this instanceof ActivityProgramming){
//                System.out.println("===="+this.getClass());
//                return (ActivityProgramming)this.clone();
//            }
//            System.out.println("---"+this.getClass());
            return super.clone();
        } catch (ActivityException e) {
            throw new RuntimeException(e);
        }
//        return activity;
    }

    @Override
    public String toString() {
        return name +": "+ description+"\n"+
        "Total executions: "+ executions.size();
    }
}
