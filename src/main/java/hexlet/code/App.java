package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {
        StringSchema s = new StringSchema();
        boolean isTrue = s.required().minLength(2).contains("123").isValid("1234");
        System.out.println(isTrue);

    }
}