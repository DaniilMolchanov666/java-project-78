package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("StringSchema work test")
    public void stringSchemaTest() {

        StringSchema stringSchema = validator.string();

        assertTrue(stringSchema.isValid(null));
        assertTrue(stringSchema.isValid(3));
        assertFalse(stringSchema.required().isValid(""));
        assertTrue(stringSchema.contains("abc").isValid("abchuddw"));
        assertFalse(stringSchema.minLength(2).isValid("qw"));
    }

    @Test
    @DisplayName("NumberSchema work test")
    public void numberSchemaTest() {

        NumberSchema numberSchema = validator.number();

        assertTrue(numberSchema.isValid(null));
        assertTrue(numberSchema.isValid("3"));
        assertFalse(numberSchema.required().isValid("234"));
        assertTrue(numberSchema.positive().isValid(3));
        assertFalse(numberSchema.range(0,3).isValid(100));
    }

    @Test
    @DisplayName("MapSchema work test")
    public void mapSchemaTest() {

        MapSchema mapSchema = validator.map();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertTrue(mapSchema.isValid(null));
        assertTrue(mapSchema.isValid("3"));
        assertFalse(mapSchema.required().isValid(null));
        assertTrue(mapSchema.isValid(new HashMap<>()));
        assertTrue(mapSchema.isValid(data));
        assertFalse(mapSchema.sizeOf(2).isValid(data));
        data.put("key2", "value2");
        assertTrue(mapSchema.sizeOf(2).isValid(data));

    }
}
