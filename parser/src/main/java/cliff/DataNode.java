package cliff;

import cliff.source.Phrase;
import cliff.source.Word;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Corresponds to a node in the data graph.
 * Constable & ConstantDesc should limit values to scalars and References
 */
public class DataNode extends GraphNode<DataNode> implements Flow.Subscriber<DataNode> {
    private final List<Flow.Subscription> subscriptions = Collections.synchronizedList(new LinkedList<>());

    private AtomicReference value;

    DataNode(Word name, DataNode parent) {
        super(name, parent);
    }

    DataNode() {
        super(null, null);
    }

    @Override
    protected DataNode createNode(Word name) {
        return new DataNode(name, this);
    }

    public synchronized <T> T value() {
        T result = (T) value.get();
        if (result == null) {
            result = (T) labels().stream()
                    .flatMap(l -> l.definitions().entrySet().stream())
                    .sorted(Comparator.of::definitions)
                    .peek(e -> {
                        // resulting value depends on all tested conditions
                        if (e.getValue() != null) {
                            e.getValue().dependencies().forEach(dep -> dep.subscribe(this));
                        }
                    })
                    .filter(e -> e.getValue() == null || e.getValue().test(this))
                    .map(Map.Entry::getKey)
                    .map(d -> {
                        d.dependencies().forEach(dep -> dep.subscribe(this));
                        return d.apply(this);
                    })
                    .findFirst().orElse(null);
            if (result == null) {
                parent().remove(this);
            } else {
                value.set(result);
            }
            // notify all dependants
            new Thread(() -> submit(this)).run();
        }
        return result;
    }

    @Override
    public DataNode a(Phrase path) {
        return path.forward(this, GraphNode::child);
    }

    public Map<String, Object> toMap() {
        return root(root -> {
            HashMap<String, Object> result = new HashMap<>();
            result.put("id", root.value.get());
            for (Word key :  root.children.keySet()) {
                Object value = root.child(key).value();
                result.put(key.normalized(), value);
            }
            return result;
        });
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscriptions.add(subscription);
    }

    @Override
    public void onNext(DataNode dataNode) {
        synchronized (this) {
            subscriptions.forEach(Flow.Subscription::cancel);
            subscriptions.clear();
            value.set(null);
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
