package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        Predicate<Object> p = (s) -> !Objects.equals(s, "") && s.getClass() == String.class;
        super.addPredicate(super.getRequiredCheckTitle(), p);
        return this;
    }

    public StringSchema minLength(int number) {
        Predicate<Object> p = (string) -> ((String) string).length() >= number;
        super.addPredicate("minLength", p);
        return this;
    }

    public StringSchema contains(String string) {
        Predicate<Object> p = (s) -> ((String) s).contains(string);
        super.addPredicate("contains", p);
        return this;
    }
}
