package cliff.source.strings;

import cliff.Cliff;
import cliff.characters.Escape;

import java.util.concurrent.ConcurrentHashMap;

public class Escaped extends Cliff<Cliff> {
    static {
        Cliff.initialize(
                Escape.class,
                Escaped.class,
                EscapedTab.class,
                EscapedNewline.class,
                EscapedDoubleQuote.class,
                LineRet.class
        );
    }

    private char value;

    public Escaped(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }

    public void value(char c) {
        this.value = c;
    }

    public char value() {
        return value;
    }
}
