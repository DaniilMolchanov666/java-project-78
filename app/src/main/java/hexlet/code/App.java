package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();

        StringSchema schema = v.string();

        // Пока на вызван метод required(), null и пустая строка считаются валидным
        System.out.println(schema.isValid("")); // true
        System.out.println(schema.isValid(null)); // true

        System.out.println(schema.required());
        System.out.println(schema.isValid(null)); // false
        System.out.println(schema.isValid("")); // false
        System.out.println(schema.isValid(5)); // false
        System.out.println(schema.isValid("what does the fox say")); // true
        System.out.println(schema.isValid("hexlet")); // true
        System.out.println(schema.contains("wh").isValid("what does the fox say")); // true
        System.out.println(schema.contains("what").isValid("what does the fox say")); // true
        System.out.println(schema.contains("whatthe").isValid("what does the fox say")); // false
        System.out.println(schema.isValid("what does the fox say")); // false
        // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")

        Validator validator2 = new Validator();
        NumberSchema n = validator2.number();
        System.out.println(String.format("null: %s\n 1: %s\n 2: %s\n 3: %s\n", n.isValid(null),
                n.positive().isValid(null), n.required(), n.positive()
                        .range(0, 3).isValid(-1)));
        System.out.println(n.isValid(40));
        System.out.println(n.isValid(3));

        Validator val = new Validator();

        MapSchema schemaMap = val.map();

        System.out.println("check map: ");

        System.out.println("null: " + schemaMap.isValid(null)); // true

        System.out.println(schemaMap.required().isValid(null)); // false
        System.out.println(schemaMap.isValid(new HashMap())); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        System.out.println(schemaMap.isValid(data)); // true

        System.out.println(schemaMap.sizeOf(2));

        System.out.println(schemaMap.isValid(data));  // false
        System.out.println(data.put("key2", "value2"));
        System.out.println(schemaMap.isValid(data)); // true
    }
}