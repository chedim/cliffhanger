package cliff.source.strings;

import cliff.Cliff;
import cliff.Group;

import java.util.concurrent.ConcurrentHashMap;

public class EscapedDoubleQuote extends Cliff<Cliff> {
    static {
        from(StringCharacter.class)
                .split(Group.collect(
                        Cliff.match(StringCharacter.class, Escaped.class),
                        c -> c.value() == '"'
                ))
                .labeled(EscapedDoubleQuote.class);
    }
    public EscapedDoubleQuote(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
