package cliff;

import java.util.Collections;
import java.util.Set;

public class StaticDefinition<T> extends Definition<T> {

    private final T data;

    public StaticDefinition(T data) {
        this.data = data;
    }

    @Override
    public Set<DataNode> dependencies() {
        return Collections.emptySet();
    }

    @Override
    public T apply(DataNode dataNode) {
        return data;
    }
}
