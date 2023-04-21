package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BasicSchema{

    public StringSchema required() {
        Predicate<Object> p = (s) -> !Objects.equals(s, "") && !Objects.equals(s, null)
                && s.getClass() == String.class;
        addPredicateInList(p);
        return this;
    }

    public StringSchema minLength(int number) {
        Predicate<Object> p = (string) -> string.getClass() == String.class && ((String) string).length() >= number;
        addPredicateInList(p);
        return this;
    }

    public StringSchema contains(String string) {
        Predicate<Object> p = (s) -> s.getClass() == String.class && ((String) s).contains(string);
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
