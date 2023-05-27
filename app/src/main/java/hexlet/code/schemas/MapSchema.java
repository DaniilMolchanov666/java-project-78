package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Object> p = (s) -> s instanceof Map;
        super.addPredicate(super.getRequiredCheckTitle(), p);
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Object> p = (s) -> ((Map<?, ?>) s).size() == size;
        super.addPredicate("sizeof", p);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        Predicate<Object> p = (s) -> map.entrySet()
                .stream()
                .allMatch(entry -> entry.getValue().isValid(((Map<?, ?>) s).get(entry.getKey())));

        super.addPredicate("shape", p);
        return this;
    }
}
