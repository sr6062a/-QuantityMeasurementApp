import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    QuantityMeasurementApp.Length l(double v, QuantityMeasurementApp.Length.LengthUnit u) {
        return new QuantityMeasurementApp.Length(v, u);
    }

    @Test
    public void yardEqualsFeet() {
        assertTrue(l(1, QuantityMeasurementApp.Length.LengthUnit.YARDS)
                .equals(l(3, QuantityMeasurementApp.Length.LengthUnit.FEET)));
    }

    @Test
    public void yardEqualsInches() {
        assertTrue(l(1, QuantityMeasurementApp.Length.LengthUnit.YARDS)
                .equals(l(36, QuantityMeasurementApp.Length.LengthUnit.INCHES)));
    }

    @Test
    public void centimeterEqualsInches() {
        assertTrue(l(1, QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS)
                .equals(l(0.393701, QuantityMeasurementApp.Length.LengthUnit.INCHES)));
    }

    @Test
    public void yardNotEqualFeet() {
        assertFalse(l(1, QuantityMeasurementApp.Length.LengthUnit.YARDS)
                .equals(l(2, QuantityMeasurementApp.Length.LengthUnit.FEET)));
    }

    @Test
    public void centimeterNotEqualFeet() {
        assertFalse(l(1, QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS)
                .equals(l(1, QuantityMeasurementApp.Length.LengthUnit.FEET)));
    }

    @Test
    public void transitiveProperty() {
        var yard = l(1, QuantityMeasurementApp.Length.LengthUnit.YARDS);
        var feet = l(3, QuantityMeasurementApp.Length.LengthUnit.FEET);
        var inches = l(36, QuantityMeasurementApp.Length.LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    @Test
    public void reflexiveProperty() {
        var obj = l(1, QuantityMeasurementApp.Length.LengthUnit.YARDS);
        assertTrue(obj.equals(obj));
    }

    @Test
    public void nullCheck() {
        var obj = l(1, QuantityMeasurementApp.Length.LengthUnit.YARDS);
        assertFalse(obj.equals(null));
    }

    @Test
    public void sameUnitDifferentValue() {
        assertFalse(l(1, QuantityMeasurementApp.Length.LengthUnit.YARDS)
                .equals(l(2, QuantityMeasurementApp.Length.LengthUnit.YARDS)));
    }

    @Test
    public void complexScenario() {
        assertTrue(l(2, QuantityMeasurementApp.Length.LengthUnit.YARDS)
                .equals(l(6, QuantityMeasurementApp.Length.LengthUnit.FEET)));

        assertTrue(l(6, QuantityMeasurementApp.Length.LengthUnit.FEET)
                .equals(l(72, QuantityMeasurementApp.Length.LengthUnit.INCHES)));
    }

    @Test
    public void centimeterToFeet() {
        assertTrue(l(30.48, QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS)
                .equals(l(1, QuantityMeasurementApp.Length.LengthUnit.FEET)));
    }
}