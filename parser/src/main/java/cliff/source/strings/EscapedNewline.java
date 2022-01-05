package cliff.source.strings;

import cliff.Cliff;
import cliff.Group;
import cliff.characters.Escape;
import cliff.source.SourceCharacter;

import java.util.concurrent.ConcurrentHashMap;

public class EscapedNewline extends Cliff<Cliff> {
    static {
        from(SourceCharacter.class)
                .split(Group.collect(
                        Cliff.match(SourceCharacter.class, Escape.class),
                        c -> c.value() == 'n'
                ))
                .labeled(EscapedNewline.class);
    }
    public EscapedNewline(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
