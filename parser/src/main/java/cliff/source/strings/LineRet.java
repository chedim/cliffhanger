package cliff.source.strings;

import cliff.Cliff;
import cliff.Group;
import cliff.characters.Escape;

import java.util.concurrent.ConcurrentHashMap;

public class LineRet extends Cliff<Cliff> {
    static {
        from(StringCharacter.class)
                .split(Group.collect(
                        Cliff.match(StringCharacter.class, Escape.class),
                        c -> c.value() == 'n'
                ))
                .peek(g -> g.last().as(Escaped.class).value('\r'))
                .labeled(LineRet.class);
    }
    public LineRet(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
