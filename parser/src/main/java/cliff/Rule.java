package cliff;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Rule<T extends Cliff<Cliff>> implements Predicate<T> {

    private final Class<T> target;

    public Rule(Class<T> type) {
        this.target = type;
    }

    @Override
    public boolean test(T t) {
        return false;
    }

    public Rule<T> is() {
        return this;
    }
}
