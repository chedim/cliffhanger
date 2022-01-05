package cliff.characters;

import cliff.Cliff;

import java.util.concurrent.ConcurrentHashMap;

public class RightParenthesis extends Cliff<Cliff> {
    static {
        CliffChar.from(')').label(RightParenthesis.class);
    }

    public RightParenthesis(ConcurrentHashMap<Class<? extends Cliff<Cliff>>, Cliff<Cliff>> values) {
        super(values);
    }
}
