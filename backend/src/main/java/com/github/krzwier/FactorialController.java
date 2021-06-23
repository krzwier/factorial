package com.github.krzwier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FactorialController {

    @CrossOrigin
    @GetMapping("/api/factorial")
    public ResponseEntity<Object> GetFactorial(@RequestParam String input) {
        int type = checkType(input);
        switch (type) {
            case 1: {
                // Integer
                int integerInput = Integer.parseInt(input);
                BigInteger response = Factorial.GetFactorial(integerInput);
                return ResponseEntity.ok(response);
            }
            case 2: {
                // Double
                double doubleInput = Double.parseDouble(input);
                Factorial.GetFactorial(doubleInput);
            }
            case 3: {
                // String
                Factorial.GetFactorial(input);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Argument must be an integer.");

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    private int checkType(String input) {
        try {
            Integer.parseInt(input);
            // made it past previous line, so input is integer
            return 1;
        } catch (Exception notInt) {
            // input is not integer
            try {
                Double.parseDouble(input);
                // made it past previous line, so input is a double
                return 2;
            } catch (Exception notDouble) {
                // input is String
                return 3;
            }
        }
    }


}
