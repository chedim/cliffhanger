package cliff.source;

import cliff.Cliff;
import cliff.characters.Escape;
import cliff.characters.Hex;

import java.util.concurrent.ConcurrentHashMap;

public class Unicode extends Cliff<Cliff> {
    static {
        from(SourceCharacter.class)
                .split((g, c) -> (
                        (g.empty() && !c.is(Escape.class))
                                || (g.size() == 1 && c.value() != 'u')
                                || (g.size() <= 6 && c.is(Hex.class))
                                || (g.size() > 6)
                        ))
                .labeled(Unicode.class);
    }

    public Unicode(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
