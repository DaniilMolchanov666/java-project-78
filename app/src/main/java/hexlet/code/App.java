package hexlet.code;


import hexlet.code.schemas.*;

import hexlet.code.schemas.StringSchema;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
//        Validator v = new Validator();
//
//        StringSchema s = v.string();
//
//        // Пока на вызван метод required(), null и пустая строка считаются валидным
//        System.out.println(s.isValid("")); // true
//        System.out.println(s.isValid(null)); // true
//
//        System.out.println(s.required());
//        System.out.println(s.isValid(null)); // false
//        System.out.println(s.isValid("")); // false
//        System.out.println(s.isValid(5)); // false
//        System.out.println(s.isValid("what does the fox say")); // true
//        System.out.println(s.isValid("hexlet")); // true
//        System.out.println(s.contains("wh").isValid("what does the fox say")); // true
//        System.out.println(s.contains("what").isValid("what does the fox say")); // true
//        System.out.println(s.contains("whatthe").isValid("what does the fox say")); // false
//        System.out.println(s.isValid("what does the fox say")); // false
//        // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")
//
//        Validator validator2 = new Validator();
//        NumberSchema n = validator2.number();
//        System.out.println(String.format("null: %s\n 1: %s\n 2: %s\n 3: %s\n", n.isValid(null),
//                n.positive().isValid(null), n.required(), n.positive()
//                        .range(0, 3).isValid(-1)));
//        System.out.println(n.isValid(40));
//        System.out.println(n.isValid(3));
//
//        Validator val = new Validator();
//
//        MapSchema schemaMap = val.map();
//
//        System.out.println("check map: ");
//
//        System.out.println("null: " + schemaMap.isValid(null)); // true
//
//        System.out.println(schemaMap.required().isValid(null)); // false
//        System.out.println(schemaMap.isValid(new HashMap())); // true
//        Map<String, String> data = new HashMap<>();
//        data.put("key1", "value1");
//        System.out.println(schemaMap.isValid(data)); // true
//
//        System.out.println(schemaMap.sizeOf(2));
//
//        System.out.println(schemaMap.isValid(data));  // false
//        System.out.println(data.put("key2", "value2"));
//        System.out.println(schemaMap.isValid(data)); // true

        Validator v2 = new Validator();

        MapSchema s2 = v2.map();


        Map<String, BasicSchema> schemas = new HashMap<>();
        schemas.put("name", v2.string().required());
        schemas.put("age", v2.number().positive());
        System.out.println(s2.shape(schemas));

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        System.out.println(s2.isValid(human1)); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "a");
        human2.put("age", null);
        System.out.println(s2.isValid(human2)); //

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        System.out.println(s2.isValid(human3)); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        System.out.println(s2.isValid(human4));
    }
}