package modules.standard.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * The calculation process of standard calculator class
 */

public class StandardCalculation {

    /**
     * calculate method which uses for calculation of standard arithmetic by using big decimal is the base value
     * @param first ~ the first number use in the process of the calculation with the second one
     * @param second ~ the second number use in the process of the calculation with the first one
     * @param op ~ the operator that specify the type of calculation between two numbers
     * @return result ~ the result of the calculation as a string
     * */
    public static @NotNull String calculate(String first, String second, @Nullable String op) {

        BigDecimal result;

        if (op == null) op = "=";
        if (first == null || first.equals("?")) first = "0";
        if (second == null) second = "0";

        first = first.replaceAll(",", "");
        second = second.replaceAll(",", "");

        try {


            switch (op) {

                case "+" -> result = new BigDecimal(first).add(new BigDecimal(second));

                case "-" -> result = new BigDecimal(first).subtract(new BigDecimal(second));

                case "/" -> result = new BigDecimal(first).divide(new BigDecimal(second), new MathContext(12));

                case "*" -> result = new BigDecimal(first).multiply(new BigDecimal(second));

                case "%" -> result = new BigDecimal(first).divide(new BigDecimal(100), new MathContext(12));

                default -> result = new BigDecimal(second);
            }
        } catch (Exception e){
            return "Error";
        }

        return (result.toString().length() > 15)
                ? new DecimalFormat("#.###############E0").format(result)
                : result.toString();

    }



}
