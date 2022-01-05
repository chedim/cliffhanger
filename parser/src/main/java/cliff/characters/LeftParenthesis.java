package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class LeftParenthesis extends Cliff<Cliff> {
    static {
        CliffChar.from('(').label(LeftParenthesis.class);
    }

    public LeftParenthesis(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
