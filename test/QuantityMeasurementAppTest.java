
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {


    @Test
    public void testFeetEqualsInches() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testLengthConversion() {
        Length l = new Length(1, LengthUnit.FEET);
        Length result = l.convertTo(LengthUnit.INCHES);
        assertEquals(12.0, result.getValue(), 0.01);
    }

    @Test
    public void testLengthAddition() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        Length result = l1.add(l2);
        assertEquals(2.0, result.getValue(), 0.01);
    }


    @Test
    public void testKilogramEqualsGram() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);
        assertTrue(w1.equals(w2));
    }

    @Test
    public void testKilogramToPoundConversion() {
        Weight w = new Weight(1, WeightUnit.KILOGRAM);
        Weight result = w.convertTo(WeightUnit.POUND);
        assertEquals(2.20462, result.getValue(), 0.01);
    }

    @Test
    public void testWeightAddition() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);
        Weight result = w1.add(w2);
        assertEquals(2.0, result.getValue(), 0.01);
    }

    @Test
    public void testWeightAdditionWithTargetUnit() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);
        Weight result = w1.add(w2, WeightUnit.GRAM);
        assertEquals(2000.0, result.getValue(), 0.01);
    }


    @Test
    public void testNullComparison() {
        Weight w = new Weight(1, WeightUnit.KILOGRAM);
        assertFalse(w.equals(null));
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Weight(1, null);
        });
    }
}