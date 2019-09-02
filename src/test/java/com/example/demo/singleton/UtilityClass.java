package com.example.demo.singleton;

public class UtilityClass {
    private UtilityClass(){
        throw new AssertionError();
    }

    static boolean isRomanNumeral(String s){
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
    public static void main(String[] args) {
        UtilityClass uc = new UtilityClass();
    }
}


