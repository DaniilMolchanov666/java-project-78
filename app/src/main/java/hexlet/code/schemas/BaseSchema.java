package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final Map<String, Predicate<Object>> predicates = new LinkedHashMap<>();

    public final boolean isValid(Object o) {
        return o == null ? !predicates.containsKey("required") : predicates.values()
                .stream()
                .allMatch(value -> value.test(o));
    }

    public final void addPredicate(String name, Predicate<Object> p) {
        predicates.put(name, p);
    }

    public final String getRequiredCheckTitle() {
        return "required";
    }
}
