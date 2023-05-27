package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected final Map<String, Predicate<Object>> predicates = new LinkedHashMap<>();

    protected boolean required = false;

    public final boolean isValid(Object o) {
        if (!required) {
            boolean requiredCheck = predicates.get("required").test(o);
            if (!requiredCheck) {
                return true;
            }
        }
        return predicates.values()
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
