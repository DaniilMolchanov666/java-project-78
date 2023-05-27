package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        Predicate<Object> p = (s) -> s instanceof Integer;
        super.addPredicate(getRequiredCheckTitle(), p);
    }

    public NumberSchema required() {
        required = true;
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
