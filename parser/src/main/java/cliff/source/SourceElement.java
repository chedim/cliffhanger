package cliff.source;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public abstract class SourceElement extends Cliff<Cliff> {
    private Position position;

    protected SourceElement(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }

    public Position position() {
        return position;
    }

    public SourceElement position(Position position) {
        this.position = position;
        return this;
    }

}