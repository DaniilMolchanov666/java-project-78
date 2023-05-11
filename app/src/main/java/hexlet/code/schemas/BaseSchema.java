package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final ArrayList<Predicate<Object>> checkList = new ArrayList<>();

    private Object stringForTest;

    public final boolean isValid(Object o) {
        this.stringForTest = o;
        return checkList.stream().allMatch(value -> value.test(stringForTest));
    }

    public final void addPredicateInList(Predicate<Object> p) {
        checkList.add(p);
    }
}
