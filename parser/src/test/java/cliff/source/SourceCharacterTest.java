package cliff.source;

import cliff.Cliff;

public class SourceCharacterTest {

    private static PositionTracker tracker = new PositionTracker("tests");

    public static void post(String string) {
        string.chars().forEach(c -> post((char) c));
        post((char)0);
    }

    public static void post(char chr) {
        new SourceCharacter(chr, tracker.position()).post();
        tracker.advance(chr);
    }

    public static void reset() {
        tracker.reset();
    }

}