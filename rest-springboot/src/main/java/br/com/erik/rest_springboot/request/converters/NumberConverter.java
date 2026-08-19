package br.com.erik.rest_springboot.request.converters;

import br.com.erik.rest_springboot.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) throws IllegalArgumentException {

        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.00
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static void verifyNumbers(String number){
        if(!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");
    }

    public static void verifyNumbers(String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
    }

    public static boolean isZero(String number){
        return number.equals("0");
    }

    public static void divisionByZero(String number){
        if(isZero(number)) throw new UnsupportedMathOperationException("The divisor number must be different from 0!");
    }
}
