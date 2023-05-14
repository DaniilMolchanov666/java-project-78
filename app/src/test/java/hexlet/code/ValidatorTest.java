package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("String Schema work test")
    public void stringSchemaTest() {

        StringSchema stringSchema = validator.string();

        assertTrue(stringSchema.isValid(""));
        assertTrue(stringSchema.isValid(null));
        assertTrue(stringSchema.isValid(3));
        assertFalse(stringSchema.required().isValid(""));
        assertTrue(stringSchema.contains("abc").isValid("abchuddw"));
        assertFalse(stringSchema.minLength(2).isValid("qw"));
    }

    @Test
    @DisplayName("Number Schema work test")
    public void numberSchemaTest() {

        NumberSchema numberSchema = validator.number();

        assertTrue(numberSchema.isValid(null));
        assertTrue(numberSchema.isValid("3"));
        assertFalse(numberSchema.required().isValid(null));
        assertFalse(numberSchema.required().isValid("234"));
        assertTrue(numberSchema.positive().isValid(3));
        assertFalse(numberSchema.range(0, 3).isValid(100));

    }

    @Test
    @DisplayName("Map Schema work test")
    public void mapSchemaTest() {

        MapSchema mapSchema = validator.map();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertTrue(mapSchema.isValid(null));
        assertTrue(mapSchema.isValid("3"));
        assertFalse(mapSchema.required().isValid(null));
        assertTrue(mapSchema.isValid(new HashMap<>()));
        assertTrue(mapSchema.isValid(data));
        assertFalse(mapSchema.sizeof(2).isValid(data));
        data.put("key2", "value2");
        assertTrue(mapSchema.sizeof(2).isValid(data));

    }

    @Test
    @DisplayName("Map Shape Schema work test")
    public void mapShapeSchemaTest() {

        MapSchema schema = validator.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "a");
        human2.put("age", null);
        assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3)); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(schema.isValid(human4));

    }
}
