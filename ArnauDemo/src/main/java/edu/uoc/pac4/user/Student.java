package edu.uoc.pac4.user;

import edu.uoc.pac4.execution.Execution;

import java.util.LinkedList;

public class Student extends User{
    private LinkedList<Execution> executions;

    public Student(String email, String name, String surname) throws UserException {
        super(email, name, surname);
        executions = new LinkedList<>();
    }

    public void addExecution(Execution execution){
        executions.add(execution);
    }

    public LinkedList<Execution> getExecutions() {
        return executions;
    }

    public Execution getLastExecutionSubmitted(){
        return executions.getLast();
    }

    @Override
    public String toString() {
        return "[STUDENT] "+getName()+" " +getSurname() + " ("+ getEmail()+") Total executions: "+executions.size();
    }
}
