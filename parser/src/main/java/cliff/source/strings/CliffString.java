package cliff.source.strings;

import cliff.Cliff;
import cliff.Group;
import cliff.characters.Escape;
import cliff.source.SourceCharacter;

import java.util.concurrent.ConcurrentHashMap;

public class CliffString extends Cliff<Cliff> {
    private String value;

    static {
        Cliff.initialize(StringCharacter.class);
    }

    public CliffString(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
        StringBuilder valueBuilder = new StringBuilder();
        ((Group<SourceCharacter>) as(Group.class)).members().stream()
                .filter(c -> c.isnt(Escape.class))
                .map(c -> ((Cliff<Cliff>)c).as(StringCharacter.class).value())
                .forEach(valueBuilder::append);
        this.value = valueBuilder.toString();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof String) {
            return toString().equals(o);
        }
        return super.equals(o);
    }
}
