package cliff;

import java.util.Set;
import java.util.function.Function;

public abstract class Definition<T> implements Function<DataNode, T> {

    public static final Definition<Boolean> FALSE = new StaticDefinition<>(Boolean.FALSE);

    public abstract Set<DataNode> dependencies();
}
