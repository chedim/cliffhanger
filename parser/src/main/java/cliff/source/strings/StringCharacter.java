package cliff.source.strings;

import cliff.Cliff;
import cliff.characters.DoubleQuote;
import cliff.source.SourceCharacter;

import java.util.concurrent.ConcurrentHashMap;

public class StringCharacter extends Cliff<Cliff> {
    static {
        Cliff.initialize(Escaped.class);
        Cliff.initialize(DoubleQuote.class);
        from(SourceCharacter.class)
                .after(c -> c.isnt(StringCharacter.class) && c.isnt(Escaped.class) && c.is(DoubleQuote.class))
                .each(sub -> {
                    sub
                            .peek(c -> c.label(StringCharacter.class))
                            .until(c -> c.isnt(Escaped.class) && c.is(DoubleQuote.class))
                            .next(g -> {
                                g.label(CliffString.class);
                            });
                });
    }

    public StringCharacter(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }

    public char value() {
       if (is(Escaped.class)) {
           return as(Escaped.class).value();
       } else {
           return as(SourceCharacter.class).value();
       }
    }

    @Override
    public String toString() {
        return as(SourceCharacter.class).toString();
    }
}
