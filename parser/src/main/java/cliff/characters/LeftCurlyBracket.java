package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class LeftCurlyBracket extends Cliff<Cliff> {
    static {
        CliffChar.from('{').label(LeftCurlyBracket.class);
    }

    public LeftCurlyBracket(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
