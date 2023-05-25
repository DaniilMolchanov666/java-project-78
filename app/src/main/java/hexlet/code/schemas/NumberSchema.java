package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        Predicate<Object> p = (s) -> s.getClass() == Integer.class;
        super.addPredicateInList(super.getRequiredCheckTitle(), p);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> p = (s) -> Objects.equals(s, null) || s.getClass() != Integer.class || (int) s > 0;
        super.addPredicateInList("positive", p);
        return this;
    }

    public NumberSchema range(int leftBorder, int rightBorder) {
        Predicate<Object> p = (s) -> s.getClass() == Integer.class
                && (int) s >= leftBorder && (int) s <= rightBorder;
        super.addPredicateInList("range", p);
        return this;
    }
}
