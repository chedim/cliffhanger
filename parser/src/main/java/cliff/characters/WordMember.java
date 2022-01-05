package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class WordMember extends Cliff<Cliff> {
    static {
        from(CliffChar.class)
                .only(c -> Character.isLetterOrDigit(c.value()))
                .labeled(WordMember.class);
    }

    public WordMember(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
