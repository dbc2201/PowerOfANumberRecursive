package io.github.dbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerCalculatorTest {

    private PowerCalculator powerCalculator;

    @BeforeEach
    void setUp() {
        powerCalculator = new PowerCalculator();
    }

    @ParameterizedTest(name = "calculatePowerRecursively({0}, {1}) = {2}")
    @CsvSource(value = {
            "2.0, 0.0, 1.0",
            "2.0, 1.0, 2.0",
            "2.0, 2.0, 4.0",
            "2.0, 3.0, 8.0",
            "2.0, 4.0, 16.0",
            "2.0, 5.0, 32.0",
            "2.0, 6.0, 64.0",
            "2.0, 7.0, 128.0",
            "2.0, 8.0, 256.0",
            "2.0, 9.0, 512.0"
    })
    void calculatePowerRecursively(double base, double exponent, double expected) {
        double result = powerCalculator.calculatePowerRecursively(base, exponent);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "calculatePowerRecursively({0}, {1}) = {2}")
    @CsvSource(value = {
            "2.0, -1.0, Double.MIN_VALUE",
            "2.0, -2.0, Double.MIN_VALUE",
            "2.0, -3.0, Double.MIN_VALUE",
            "2.0, -4.0, Double.MIN_VALUE",
            "2.0, -5.0, Double.MIN_VALUE",
            "2.0, -6.0, Double.MIN_VALUE",
            "2.0, -7.0, Double.MIN_VALUE",
            "2.0, -8.0, Double.MIN_VALUE",
            "2.0, -9.0, Double.MIN_VALUE",
            "2.0, -10.0, Double.MIN_VALUE"
    })
    void shouldReturnDoubleMinValueForNegativeExponent(double base, double exponent, double expected) {
        double result = powerCalculator.calculatePowerRecursively(base, exponent);
        assertEquals(expected, result);
    }
}