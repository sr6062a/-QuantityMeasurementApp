package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2, LengthUnit unit) {
        return l1.add(l2, unit);
    }

    public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
        return w1.equals(w2);
    }

    public static Weight demonstrateWeightConversion(Weight weight, WeightUnit toUnit) {
        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2) {
        return w1.add(w2);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2, WeightUnit unit) {
        return w1.add(w2, unit);
    }

    public static void main(String[] args) {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println("Length Equality: " + demonstrateLengthEquality(l1, l2));
        System.out.println("Length Conversion: " + demonstrateLengthConversion(l1, LengthUnit.INCHES));
        System.out.println("Length Addition: " + demonstrateLengthAddition(l1, l2));

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println("Weight Equality: " + demonstrateWeightEquality(w1, w2));
        System.out.println("Weight Conversion: " + demonstrateWeightConversion(w1, WeightUnit.POUND));
        System.out.println("Weight Addition: " + demonstrateWeightAddition(w1, w2));
    }
}