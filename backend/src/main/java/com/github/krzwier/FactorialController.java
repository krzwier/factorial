package com.github.krzwier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FactorialController {

    @GetMapping("/api/factorial")
    public ResponseEntity GetFactorial(@RequestParam int input) {
        BigInteger response = Factorial.GetFactorial(input);
        return ResponseEntity.ok(response);
    }




}
