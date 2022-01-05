package cliff.source;

import org.atteo.evo.inflector.English;

import java.util.Locale;

public class Word {

    private final boolean isPlural;
    private final String normalized;
    private final String original;

    public Word(String value) {
        this.original = value.trim().toLowerCase(Locale.ROOT);
        this.normalized = English.plural(this.original, 1);
        this.isPlural = !original.equals(normalized);
    }

    public String normalized() {
        return normalized;
    }

    public String original() {
        return original;
    }

    public boolean isPlural() {
        return isPlural;
    }
}
