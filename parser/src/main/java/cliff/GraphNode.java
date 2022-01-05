package cliff;

import cliff.source.Phrase;
import cliff.source.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public abstract class GraphNode<T extends GraphNode> extends SubmissionPublisher<T> {
    private final Word name;
    private final T parent;
    private final List<ClassNode> labels = Collections.synchronizedList(new ArrayList<>());
    protected final Map<Word, T> children = new ConcurrentHashMap<>();
    private ClusterNode handler;

    GraphNode(Word name, T parent) {
        this.name = name;
        this.parent = parent;
    }

    public Word name() {
        return name;
    }

    public T parent() {
        return parent;
    }

    public T root() {
        return (T) (parent == null ? this : parent.root());
    }

    public <X> X root(Function<T, X> f) {
        return f.apply(root());
    }

    public ClusterNode handler() {
        return handler != null ? handler : parent().handler();
    }

    public List<ClassNode> labels() {
        return labels;
    }

    protected abstract T createNode(Word name);

    public T child(Word name) {
        if (!children.containsKey(name)) {
            children.put(name, createNode(name));
        }
        return children.get(name);
    }

    public Map<Word, T> children() {
        return new HashMap<>(children);
    }

    public abstract ClassNode a(Phrase path);

    public ClassNode an(Phrase path) {
        return a(path);
    }

    public ClassNode a(String path) {
        return a(Phrase.parse(path));
    }

    public ClassNode an(String path) {
        return a(Phrase.parse(path));
    }

    protected void remove(T child) {
        children.remove(child);
    }

    public <T extends GraphNode> void replaceWith(T replacement) {
        parent.children().put(name, replacement);
    }

    public T isA(String label) {
        isA(Phrase.parse(label));
        return (T) this;
    }

    public T isA(Phrase path) {
        labels.add(root().a(path));
        return (T) this;
    }
}
