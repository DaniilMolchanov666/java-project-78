package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BasicSchema{

    public MapSchema required() {
        Predicate<Object> p = (s) -> !Objects.equals(s, null) && s instanceof Map;
        addPredicateInList(p);
        return this;
    }

    public MapSchema sizeOf(int size) {
        Predicate<Object> p = (s) -> s instanceof Map  && ((Map<?, ?>)s).size() == size;
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
