import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.Length.convert(1,
                        QuantityMeasurementApp.Length.LengthUnit.FEET,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testYardToFeet() {
        assertEquals(3.0,
                QuantityMeasurementApp.Length.convert(1,
                        QuantityMeasurementApp.Length.LengthUnit.YARDS,
                        QuantityMeasurementApp.Length.LengthUnit.FEET),
                0.0001);
    }

    @Test
    public void testCmToInches() {
        assertEquals(0.393701,
                QuantityMeasurementApp.Length.convert(1,
                        QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testInstanceConversion() {
        var length = new QuantityMeasurementApp.Length(3,
                QuantityMeasurementApp.Length.LengthUnit.FEET);

        var result = length.convertTo(
                QuantityMeasurementApp.Length.LengthUnit.INCHES);

        assertEquals(36.0, result.convertTo(
                QuantityMeasurementApp.Length.LengthUnit.INCHES).value, 0.0001);
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.Length.convert(1, null,
                        QuantityMeasurementApp.Length.LengthUnit.FEET));
    }

    @Test
    public void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.Length.convert(Double.NaN,
                        QuantityMeasurementApp.Length.LengthUnit.FEET,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES));
    }
}