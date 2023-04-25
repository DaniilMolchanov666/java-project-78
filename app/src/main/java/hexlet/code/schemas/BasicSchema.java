package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BasicSchema {

    private final ArrayList<Predicate<Object>> CHECKLIST = new ArrayList<>();

    private Object stringForTest;

    public boolean isValid(Object o) {
        this.stringForTest = o;
        return CHECKLIST.stream().allMatch(value -> value.test(stringForTest));
    }

    public void addPredicateInList(Predicate<Object> p) {
        CHECKLIST.add(p);
    }
}
