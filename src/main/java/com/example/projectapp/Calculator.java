package com.example.projectapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation) {

        double result;

        switch (operation.toLowerCase()) {
            case "add":
            case "+":
                result = num1 + num2;
                break;
            case "subtract":
            case "-":
                result = num1 - num2;
                break;
            case "multiply":
            case "*":
                result = num1 * num2;
                break;
            case "divide":
            case "/":
                if (num2 == 0) {
                    return "Error";
                }
                result = num1 / num2;
                break;
            default:
                return "Invalid";
        }

        if (result == (long) result) {
            return String.valueOf((long) result);
        } else {
            return String.valueOf(result);
        }
    }
}