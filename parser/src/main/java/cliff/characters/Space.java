package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class Space extends Cliff<Cliff> {
    static {
        CliffChar.from(' ').label(Space.class);
    }

    public Space(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
