package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        Predicate<Object> p = (s) -> !Objects.equals(s, null) && s instanceof Map;
        addPredicateInList(p);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Object> p = (s) -> s instanceof Map  && ((Map<?, ?>) s).size() == size;
        addPredicateInList(p);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {

        Predicate<Object> p = (s) -> (s instanceof Map) && map.entrySet()
                .stream()
                .allMatch(entry -> entry.getValue().isValid(((Map<?, ?>) s).get(entry.getKey())));
        addPredicateInList(p);
        return this;
    }

    @Override
    public boolean isValid(Object o) {
        return super.isValid(o);
    }

    @Override
    public void addPredicateInList(Predicate<Object> p) {
        super.addPredicateInList(p);
    }
}
