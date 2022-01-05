package cliff;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group<T extends Cliff<Cliff>> extends Cliff<Cliff> {

    private final List<T> members = new ArrayList<>();
    private T delimeter;

    public Group(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }

    public static <T extends Cliff<Cliff>> BiPredicate<Group<T>, T> collect(Predicate<T>... patterns) {
        return (g, t) -> {
            if (patterns.length <= g.size()) {
                return true;
            }
            Predicate pattern = patterns[g.size()];
            if (pattern != null) {
                if(!pattern.test(t)) {
                    g.members().clear();
                    return true;
                } else {
                    return false;
                }
            } else {
               return false;
            }
        };
    }

    protected Group add(T item) {
        members.add(item);
        return this;
    }

    public List<T> members() {
        return members;
    }

    protected Group delimeter(T delimeter) {
        this.delimeter = delimeter;
        return this;
    }

    public T delimeter() {
        return delimeter;
    }

    public boolean nonEmpty() {
        return members.size() > 0;
    }

    @Override
    public String toString() {
        return Stream.ofNullable(members)
                .flatMap(List::stream)
                .map(o -> o == null ? "null" : o)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", System.identityHashCode(this) + "@[ ", " ]" ));
    }

    public boolean empty() {
        return members.size() == 0;
    }

    public int size() {
        return members.size();
    }

    public Cliff<Cliff> last() {
        return members.get(members.size() - 1);
    }
}
