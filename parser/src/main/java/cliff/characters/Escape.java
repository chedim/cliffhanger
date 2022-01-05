package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class Escape extends Cliff<Cliff> {
    static {
        CliffChar.from('\\').label(Escape.class);
    }
    public Escape(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
