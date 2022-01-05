package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class RightCurlyBracket extends Cliff<Cliff> {
    static {
        CliffChar.from('}').label(RightCurlyBracket.class);
    }

    public RightCurlyBracket(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
