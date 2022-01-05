package cliff.source;

import cliff.Cliff;
import cliff.characters.CliffChar;

import java.util.concurrent.ConcurrentHashMap;

public class SourceCharacter extends SourceElement {

    private CliffChar value;

    public SourceCharacter(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }

    public SourceCharacter(char chr, Position position) {
        super(null);
        position(position);
        this.value = CliffChar.from(chr);
        this.is(this.value);
    }

    @Override
    public String toString() {
        if (value == null) {
            return "Unknown char";
        }
        return "Character '" + value.value() + "' at " + position();
    }

    public char value() {
        return value.value();
    }

    public CliffChar meta() {
        return value;
    }

    public SourceCharacter value(CliffChar value) {
        assert this.value == null;
        this.value = value;
        this.is(this.value);
        return this;
    }

    public SourceCharacter value(char value) {
        assert this.value == null;
        this.value = CliffChar.from(value);
        this.is(this.value);
        return this;
    }
}
