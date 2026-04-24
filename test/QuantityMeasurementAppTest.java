import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(l1, l2);
    }

    @Test
    void testInchesEquality() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    void testFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(feet, inches);
    }

    @Test
    void testFeetInequality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
        assertNotEquals(l1, l2);
    }

    @Test
    void testInchesInequality() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(24.0, Length.LengthUnit.INCHES);
        assertNotEquals(l1, l2);
    }

    @Test
    void testCrossUnitInequality() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(10.0, Length.LengthUnit.INCHES);
        assertNotEquals(feet, inches);
    }

    @Test
    void testSameReference() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(l1, l1);
    }

    @Test
    void testNullComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(l1, null);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }
}