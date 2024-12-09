package edu.uoc.pac4.execution;

import edu.uoc.pac4.activity.Activity;
import edu.uoc.pac4.user.Student;

public class Execution {
    private double score;
    private Student student;
    private Activity activity;

    public Execution(double score, Student student, Activity activity) {
        setScore(score);
        setStudent(student);
        setActivity(activity);
        this.activity.addExecution(this);
        this.student.addExecution(this);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if(score<0) score = 0;
        if(score>10) score = 10;
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return student.toString()+"\n"+
        activity.toString()+"\n"+
        "Score: "+score;
    }
}
