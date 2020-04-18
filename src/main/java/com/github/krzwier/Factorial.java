package com.github.krzwier;


import java.math.BigInteger;

/**
 * Hello world!
 */
public final class Factorial {


    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static BigInteger GetFactorial(final int input) throws IllegalArgumentException {

        if (input < 0 || input > 100) {
            throw new IllegalArgumentException("Argument must be non-negative and less than or equal to 100.");
        }
        // base case
        if (input==0){
            return BigInteger.ONE;
        }
        // recursive case
        BigInteger answer = BigInteger.valueOf(input);
        return answer.multiply(GetFactorial(input-1));

    }
}
