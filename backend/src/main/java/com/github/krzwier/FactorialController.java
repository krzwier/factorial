package com.github.krzwier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FactorialController {

    @CrossOrigin
    @GetMapping("/api/factorial")
    public ResponseEntity<BigInteger> GetFactorial(@RequestParam int input) {
        BigInteger response = Factorial.GetFactorial(input);
        return ResponseEntity.ok(response);
    }




}
