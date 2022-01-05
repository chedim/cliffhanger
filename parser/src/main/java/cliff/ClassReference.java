package cliff;

import cliff.source.Phrase;

import java.lang.constant.ConstantDesc;
import java.util.Optional;

public class ClassReference extends Reference<ClassNode> {

    public ClassReference(ClassNode root, Phrase path) {
        super(root, path);
    }

    @Override
    public ClassNode value() {
        return root().a(name());
    }

    public ClassReference is(Class type) {
        value().linkJavaClass(type);
    }
}
