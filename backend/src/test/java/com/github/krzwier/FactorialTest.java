package com.github.krzwier;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FactorialTest {

    // helper function that transforms expected string into big integer and makes assertion
    void assertFactorialOfBigInteger(String expected, int input){
        BigInteger expectedBigInt = new BigInteger(expected);
        assertEquals(expectedBigInt, Factorial.GetFactorial(input));
    }

    // helper function that transforms expected integer into string
    void assertFactorialOfBigInteger(int expected, int input){
        String s = String.valueOf(expected);
        assertFactorialOfBigInteger(s,input);
    }

    @Test
    @DisplayName("It should return 120 when input is 5")
    void Factorial_Input5_Expected120() {
        assertFactorialOfBigInteger(120,5);
    }

    @Test
    @DisplayName("It should return 1 when input is 1")
    void Factorial_Input1_Expected1() {
        assertFactorialOfBigInteger(1,1);
    }

    @Test
    @DisplayName("It should return 40320 when input is 8")
    void Factorial_Input8_Expected40320() {
        assertFactorialOfBigInteger(40320,8);
    }

    @Test
    @DisplayName("It should return 1 when input is 0"
    )
    void Factorial_Input0_Expected1() {
        assertFactorialOfBigInteger(1,0);
    }

    @Test
    @DisplayName("It should return correct BIG number when input is 100")
    void Factorial_Input100_ExpectedHuge() {
        assertFactorialOfBigInteger("9332621544394415268169923885626670049071596826438162146859"
            + "29638952175999932299156089414639761565182862536979208272237582511852109168640"
            + "00000000000000000000000",100);
    }

    @Test
    @DisplayName("It should throw exception when input is -10")
    void Factorial_InputNeg1_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(-10));
    }

    @Test
    @DisplayName("It should throw exception with message about valid values when input is -10")
    void Factorial_InputNeg1_ThrowsExceptionWithMessage() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(-10));
        Pattern p = Pattern.compile(".*non-negative.*", Pattern.CASE_INSENSITIVE);

        assertTrue(p.matcher(e.getMessage()).matches(),"Illegal Argument Exception message for non-negative numbers does not match.");
    }


    @Test
    @DisplayName("It should throw exception when input is greater than 100")
    void Factorial_InputGreaterThan100_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(105));
    }


    @Test
    @DisplayName("It should throw exception with message about valid values when input greater than 100")
    void Factorial_InputGreaterThan100_ThrowsExceptionWithMessage() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(105));
        Pattern p = Pattern.compile(".*less.*100.*", Pattern.CASE_INSENSITIVE);

        assertTrue(p.matcher(e.getMessage()).matches(),"Illegal Argument Exception message for numbers greater than 100 does not match.");
    }

    @Test
    @DisplayName("It should throw exception when input is not an integer")
    void Factorial_InputNotInteger_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(3.03));
    }


    // @Test
    // @DisplayName("It should throw exception with message when input is not an integer")
    // void Factorial_InputNotInteger_ThrowsExceptionWithMessage() {
    //     Exception e = assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(3.03));
    //     Pattern p = Pattern.compile(".*integer.*", Pattern.CASE_INSENSITIVE);

    //     assertTrue(p.matcher(e.getMessage()).matches(),"Illegal Argument Exception message for non-integers does not match.");
    // }

    @Test
    @DisplayName("It should throw exception when input is not an number")
    void Factorial_InputNotNumber_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial("hello"));
    }


    @Test
    @DisplayName("It should throw exception with message when input is string")
    void Factorial_InputNotNumber_ThrowsExceptionWithMessage() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial("hello"));
        Pattern p = Pattern.compile(".*number.*", Pattern.CASE_INSENSITIVE);

        assertTrue(p.matcher(e.getMessage()).matches(),"Illegal Argument Exception message for non-numbers does not match.");
    }

}
