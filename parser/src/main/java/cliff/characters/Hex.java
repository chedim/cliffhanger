package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Hex extends Cliff<Cliff> {
    static {
        Stream.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
                .forEach(Hex::hex);
    }

    protected static void hex(char c) {
        CliffChar.from(c).label(Hex.class);
        if (Character.isLetter(c)) {
            CliffChar.from(Character.toLowerCase(c)).label(Hex.class);
        }
    }

    public Hex(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
