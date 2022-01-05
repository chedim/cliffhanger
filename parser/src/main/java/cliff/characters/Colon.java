package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class Colon extends Cliff<Cliff> {
    static {
        CliffChar.from(':').label(Colon.class);
    }
    public Colon(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
