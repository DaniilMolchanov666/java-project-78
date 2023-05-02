package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BasicSchema {

    public NumberSchema required() {
        Predicate<Object> p = (s) -> !Objects.equals(s, null) && s.getClass() == Integer.class;
        addPredicateInList(p);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> p = (s) -> Objects.equals(s, null) || s.getClass() != Integer.class || (int) s > 0;
        addPredicateInList(p);
        return this;
    }

    public NumberSchema range(int leftBorder, int rightBorder) {
        Predicate<Object> p = (s) -> s.getClass() == Integer.class
                && (int) s >= leftBorder && (int) s <= rightBorder;
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
