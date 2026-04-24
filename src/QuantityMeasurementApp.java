package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

    static class Length {

        private double value;
        private LengthUnit unit;

        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),
            CENTIMETERS(0.393701);

            private final double conversionFactor;

            LengthUnit(double conversionFactor) {
                this.conversionFactor = conversionFactor;
            }

            public double getConversionFactor() {
                return conversionFactor;
            }
        }

        public Length(double value, LengthUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");
            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return this.value * this.unit.getConversionFactor(); // base = inches
        }

        public boolean compare(Length other) {
            if (other == null) return false;
            return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < 0.0001;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Length)) return false;
            Length other = (Length) o;
            return compare(other);
        }

        @Override
        public int hashCode() {
            return Objects.hash(convertToBaseUnit());
        }
    }

    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        boolean result = l1.equals(l2);

        System.out.println("Comparing: " + value1 + " " + unit1 +
                " and " + value2 + " " + unit2 +
                " => " + result);

        return result;
    }

    public static void main(String[] args) {

        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS,
                39.3701, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.YARDS);

        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);
    }
}