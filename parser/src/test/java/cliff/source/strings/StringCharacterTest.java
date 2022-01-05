package cliff.source.strings;

import cliff.Cliff;
import cliff.source.SourceCharacter;
import cliff.source.SourceCharacterTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class StringCharacterTest {

    @AfterEach
    public void afterEach() {
        SourceCharacterTest.reset();
    }

    @Test
    public void testStrings() {
        AtomicReference<CliffString> value = new AtomicReference<>();
        Cliff.from(CliffString.class).next(value::set);

        SourceCharacterTest.post("\"test\"");
        assertNotNull(value.get());
        assertEquals("test", value.get().toString());
        value.set(null);

    }
    @Test
    public void testEscapes() {
        AtomicReference<CliffString> value = new AtomicReference<>();
        Cliff.from(CliffString.class).next(value::set);
        SourceCharacterTest.reset();
        SourceCharacterTest.post("\"test\\t\\\"escapes\"");
        assertNotNull(value.get());
        assertEquals("test\t\"escapes", value.get().toString());
    }


}