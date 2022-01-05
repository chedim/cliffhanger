package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class DoubleQuote extends Cliff<Cliff> {
    static {
        CliffChar.from('"').label(DoubleQuote.class);
    }

    public DoubleQuote(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
