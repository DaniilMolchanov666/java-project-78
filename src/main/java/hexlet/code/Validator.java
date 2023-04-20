package hexlet.code;

import hexlet.code.schemas.StringSchema;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class Validator {

    private static Object stringForTest;

    public static void setStringForTest(Object s) {
        stringForTest = s;
    }

    public static boolean required() {
        return (!Objects.equals(stringForTest, "") && stringForTest.getClass() == String.class);
    }

    public static boolean minLength(int number) {
        if (stringForTest.getClass() == String.class) {
            String s = (String) stringForTest;
            return s.length() >= number;
        }
        return false;
    }

    public static boolean contains(String string) {
        if (stringForTest.getClass() == String.class) {
            String s = (String) stringForTest;
            return s.contains(string);
        }
        return false;
    }

}
