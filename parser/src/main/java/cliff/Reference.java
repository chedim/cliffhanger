package cliff;

import cliff.source.Phrase;

import java.lang.invoke.MethodHandles;

public abstract class Reference<T extends GraphNode> {
    private final Phrase name;
    private final T root;

    Reference(T root, Phrase name) {
        this.root = root;
        this.name = name;
    }

    public Phrase name() {
        return name;
    }

    public T root() {
        return root;
    }

    public abstract T value();

    @Override
    public Object resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
        return this;
    }

    public void is(T replacement) {
        value().replaceWith(replacement);
    }
}