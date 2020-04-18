package com.github.krzwier;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FactorialTest {

    void assertFactorialOfBigInteger(String expected, int input){
        BigInteger expectedBigInt = new BigInteger(expected);
        assertEquals(expectedBigInt, Factorial.GetFactorial(input));
    }

    void assertFactorialOfBigInteger(int expected, int input){
        String s = String.valueOf(expected);
        assertFactorialOfBigInteger(s,input);
    }

    @Test
    void Factorial_Input5_Expected120() {
        assertFactorialOfBigInteger(120,5);
    }

    @Test
    void Factorial_Input1_Expected1() {
        assertFactorialOfBigInteger(1,1);
    }

    @Test
    void Factorial_Input8_Expected40320() {
        assertFactorialOfBigInteger(40320,8);
    }

    @Test
    void Factorial_Input0_Expected1() {
        assertFactorialOfBigInteger(1,0);
    }

    @Test
    void Factorial_Input100_ExpectedHuge() {
        assertFactorialOfBigInteger("9332621544394415268169923885626670049071596826438162146859"
            + "29638952175999932299156089414639761565182862536979208272237582511852109168640"
            + "00000000000000000000000",100);
    }

    @Test
    @DisplayName("It should throw exception when input is -1")
    void Factorial_InputNeg1_ThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(-1));
    }

    @Test
    @DisplayName("It should throw exception with message about valid values when input is -1")
    void Factorial_InputNeg1_ThrowsExceptionWithMessage() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(-1));
        Pattern p = Pattern.compile(".*non-negative.*", Pattern.CASE_INSENSITIVE);

        assertTrue(p.matcher(e.getMessage()).matches(),"Illegal Argument Exception message for non-negative numbers does not match.");
    }


    @Test
    @DisplayName("It should throw exception when input is greater than 100")
    void Factorial_InputGreaterThan100_ThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(101));
    }


    @Test
    @DisplayName("It should throw exception with message about valid values when input greater than 100")
    void Factorial_InputGreaterThan100_ThrowsExceptionWithMessage() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Factorial.GetFactorial(101));
        Pattern p = Pattern.compile(".*less.*100.*", Pattern.CASE_INSENSITIVE);

        assertTrue(p.matcher(e.getMessage()).matches(),"Illegal Argument Exception message for numbers greater than 100 does not match.");
    }




}
