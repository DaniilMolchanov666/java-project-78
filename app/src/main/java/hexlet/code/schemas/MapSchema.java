package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        Predicate<Object> p = (s) -> s instanceof Map;
        super.addPredicateInList(super.getRequiredCheckTitle(), p);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Object> p = (s) -> s instanceof Map  && ((Map<?, ?>) s).size() == size;
        super.addPredicateInList("sizeof", p);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        Predicate<Object> p = (s) -> (s instanceof Map) && map.entrySet()
                .stream()
                .allMatch(entry -> entry.getValue().isValid(((Map<?, ?>) s).get(entry.getKey())));

        super.addPredicateInList("shape", p);
        return this;
    }
}
