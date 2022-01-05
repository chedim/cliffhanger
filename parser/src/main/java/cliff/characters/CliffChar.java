package cliff.characters;

import cliff.Cliff;
import cliff.source.Buffer;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CliffChar extends Cliff<Cliff> {

    static {
        CliffChar.from('\\').label(Escape.class);
    }

    private static final HashMap<java.lang.Character, CliffChar> charPool = new HashMap<>();

    private final char value;

    private CliffChar(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values, char value) {
        super(values);
        this.value = value;
    }

    public static CliffChar from(char value) {
        if (!charPool.containsKey(value)) {
            CliffChar instance = new CliffChar(null, value);
            charPool.put(value, instance);
            post(CliffChar.class, instance);
        }
        return charPool.get(value);
    }

    public static CliffChar from(Buffer buffer) throws IOException {
        char value = (char) buffer.read();
        return CliffChar.from(value);
    }

    public char value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
