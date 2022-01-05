package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class Whitespace extends Cliff<Cliff> {
    static {
        from(CliffChar.class)
                .only(c -> Character.isWhitespace(c.value()))
                .labeled(Whitespace.class);
    }

    public Whitespace(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
