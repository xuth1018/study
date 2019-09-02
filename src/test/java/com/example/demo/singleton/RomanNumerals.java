package com.example.demo.singleton;

import java.util.regex.Pattern;

public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    static boolean isRomanNumeral(String s){
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        boolean b = false;

        for(int i=0;i<num1;i++){
            long start = System.nanoTime();
            for (int j = 0; j <num2 ; j++) {
                b^=isRomanNumeral("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.println((end-start)/1_000.*num2);
        }
        if(!b){
            System.out.println();
        }
    }
}
