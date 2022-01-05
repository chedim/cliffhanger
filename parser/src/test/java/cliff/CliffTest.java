package cliff;

import cliff.characters.CliffChar;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class CliffTest {

    @Test
    void testPost() {
        AtomicBoolean received = new AtomicBoolean();
        Cliff.from(CliffChar.class).each(o -> {
            received.set(true);
            return false;
        });
        CliffChar.from(' ').post();
        assertTrue(received.get());

        // test unsubscribed
        received.set(false);
        CliffChar.from('-').post();
        assertFalse(received.get());
    }

    @Test
    void testFilter() {
        AtomicBoolean received = new AtomicBoolean();
        AtomicBoolean filtered = new AtomicBoolean();

        Cliff.from(CliffChar.class)
                .only(o -> {
                    filtered.set(true);
                    return false;
                })
                .each(o -> {
                    received.set(true);
                    return false;
                });

        CliffChar.from('-').post();
        assertTrue(filtered.get());
        assertFalse(received.get());
    }

    @Test
    void testFFI() {

    }
}