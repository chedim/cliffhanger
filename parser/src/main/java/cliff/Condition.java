package cliff;

import java.util.Set;
import java.util.function.Predicate;

public class Condition implements Predicate<DataNode> {

    private final Definition<Boolean> control;

    public Condition(Definition<Boolean> control) {
        this.control = control;
    }

    @Override
    public boolean test(DataNode dataNode) {
        return control.apply(dataNode);
    }

    public Set<DataNode> dependencies() {
        return control.dependencies();
    }
}
