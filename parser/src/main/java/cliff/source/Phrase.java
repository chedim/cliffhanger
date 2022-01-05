package cliff.source;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Phrase {
    private final Word[] words;

    public static Phrase parse(String phrase) {
        String[] tokens = phrase.split("\\s");
        Word[] words = new Word[tokens.length];
        Arrays.stream(tokens).map(Word::new).collect(Collectors.toList()).toArray(words);
        return new Phrase(words);
    }

    Phrase(Word[] words) {
        this.words = words;
    }

    public Word[] words() {
        return words;
    }

    public <T> T forward(T root, BiFunction<T, Word, T> consumer) {
        T result = (T) root;
        for (int i = 0; i < words.length; i++) {
            result = consumer.apply(result, words[i]);
        }
        return result;
    }

    public <T> T reverse(T arg, BiFunction<T, Word, T> consumer) {
        for (int i = words.length - 1; i > -1; i--) {
            arg = consumer.apply(arg, words[i]);
        }
        return arg;
    }
}
