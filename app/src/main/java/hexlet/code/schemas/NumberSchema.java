package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        Predicate<Object> p = (s) -> s.getClass() == Integer.class;
        super.addPredicate(super.getRequiredCheckTitle(), p);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> p = (s) -> (int) s > 0;
        super.addPredicate("positive", p);
        return this;
    }

    public NumberSchema range(int leftBorder, int rightBorder) {
        Predicate<Object> p = (s) -> (int) s >= leftBorder && (int) s <= rightBorder;
        super.addPredicate("range", p);
        return this;
    }
}
