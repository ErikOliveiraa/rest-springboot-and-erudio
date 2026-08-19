package br.com.erik.rest_springboot.controllers;

import br.com.erik.rest_springboot.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.erik.rest_springboot.request.converters.NumberConverter.*;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        verifyNumbers(numberOne, numberTwo);
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        verifyNumbers(numberOne, numberTwo);
        return math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        verifyNumbers(numberOne, numberTwo);
        return (isZero(numberOne) || isZero(numberTwo)) ? 0D : math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        verifyNumbers(numberOne, numberTwo);
        divisionByZero(numberTwo);
        return math.division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        verifyNumbers(numberOne, numberTwo);
        return math.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(
            @PathVariable("number") String number
    ) {
        verifyNumbers(number);
        return isZero(number) ? 0D : math.squareRoot(convertToDouble(number));
    }

}
