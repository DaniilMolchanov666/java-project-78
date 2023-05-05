package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        Predicate<Object> p = (s) -> !Objects.equals(s, "") && !Objects.equals(s, null)
                && s.getClass() == String.class;
        super.addPredicateInList(p);
        return this;
    }

    public StringSchema minLength(int number) {
        Predicate<Object> p = (string) -> string.getClass() == String.class && ((String) string).length() >= number;
        super.addPredicateInList(p);
        return this;
    }

    public StringSchema contains(String string) {
        Predicate<Object> p = (s) -> s.getClass() == String.class && ((String) s).contains(string);
        super.addPredicateInList(p);
        return this;
    }
}
