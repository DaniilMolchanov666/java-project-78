package hexlet.code.schemas;

import hexlet.code.Validator;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StringSchema {

    private final ArrayList<Predicate<Object>> listOfValid = new ArrayList<>();

    private final Object stringForTest = new Object();

    public StringSchema required() {
        Predicate<Object> p = (s) -> Validator.required();
        listOfValid.add(p);
        return this;
    }

    public StringSchema minLength(int number) {
            Predicate<Object> p = (s) -> Validator.minLength(number);
            listOfValid.add(p);
            return this;
    }

    public StringSchema contains(String string) {
            Predicate<Object> p = (s) -> Validator.contains(string);
            listOfValid.add(p);
            return this;
    }

    public boolean isValid(Object o) {
        Validator.setStringForTest(o);
        return listOfValid.stream().allMatch(value -> value.test(stringForTest));
    }
}
