package cliff.source.strings;

import cliff.Cliff;
import cliff.Group;
import cliff.characters.Escape;

import java.util.concurrent.ConcurrentHashMap;

public class EscapedTab extends Cliff<Cliff> {
    static {
        from(StringCharacter.class)
                .split(Group.collect(
                        c -> c.is(Escape.class),
                        c -> c.value() == 't'
                ))
                .peek(g -> g.last().as(Escaped.class).value('\t'))
                .labeled(EscapedTab.class);
    }

    public EscapedTab(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
