package cliff.characters;

import cliff.Cliff;
import cliff.source.SourceCharacter;

import java.util.concurrent.ConcurrentHashMap;

public class EOF extends Cliff<Cliff> {
    static {
        from(SourceCharacter.class)
                .only(c -> c.value() == 0)
                .label(EOF.class);
    }
    public EOF(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
