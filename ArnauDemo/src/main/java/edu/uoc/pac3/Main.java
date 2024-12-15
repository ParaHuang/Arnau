package edu.uoc.pac3;

public class Main {
    public static void main(String[] args) {
//        String regex = "[A-Z]+[a-z]*\\d*(, [A-Z]+[a-z]*\\d*)*";
//        System.out.println("N, O, Ar, CO2".matches(regex));
//
//        System.out.println(10/0);

        String regex = "\\d+([.]\\d+){0,2}";
        System.out.println("17".matches(regex));
    }
}
