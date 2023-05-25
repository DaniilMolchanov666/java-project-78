package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final Map<String, Predicate<Object>> checkList = new LinkedHashMap<>();

    public final boolean isValid(Object o) {
        if (o == null && checkList.containsKey("required")) {
            return false;
        }
        return checkList.values().stream()
                .allMatch(value -> value.test(o));
    }

    public final void addPredicateInList(String name, Predicate<Object> p) {
        checkList.put(name, p);
    }

    public final String getRequiredCheckTitle() {
        return "required";
    }
}
