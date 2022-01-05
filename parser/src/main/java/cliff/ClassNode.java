package cliff;

import cliff.source.Phrase;
import cliff.source.Word;
import com.google.common.collect.Comparators;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassNode extends GraphNode<ClassNode> {
    private Map<ClassNode, Condition> nodeClassificationConditions = new ConcurrentHashMap<>();
    private Map<Definition<?>, Condition> definitions = new ConcurrentHashMap<>();
    private Map<String, Comparators> members = new ConcurrentHashMap<>();

    public ClassNode(Word name, ClassNode parent) {
        super(name, parent);
    }

    public ClassNode() {
        super(null, null);
    }

    @Override
    protected ClassNode createNode(Word name) {
        return new ClassNode(name, this);
    }

    @Override
    public ClassNode a(Phrase path) {
        return path.reverse(this, ClassNode::child);
    }

    public Map<Definition<?>, Condition> definitions() {
        return definitions;
    }

    public void linkJavaClass(Class type) {

    }
}
