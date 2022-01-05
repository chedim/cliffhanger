package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class WordBreaker extends Cliff<Cliff> {
    static {
        from(CliffChar.class)
                .only(c -> !Character.isLetterOrDigit(c.value()))
                .labeled(WordBreaker.class);
    }

    public WordBreaker(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
