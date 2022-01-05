package cliff;

import cliff.source.Phrase;

import java.lang.constant.ConstantDesc;
import java.util.Optional;

public class DataReference extends Reference<DataNode> {
    public DataReference(DataNode root, Phrase path) {
        super(root, path);
    }

    @Override
    public DataNode value() {
        return null;
    }

    @Override
    public Optional<? extends ConstantDesc> describeConstable() {
        return Optional.of(this);
    }

}
