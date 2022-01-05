package cliff.source.strings;

import cliff.Cliff;
import cliff.source.SourceCharacterTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class EscapedTabTest {

    @Test
    public void testEscapedTab() {
        AtomicReference<EscapedTab> value = new AtomicReference<>();
        Cliff.from(EscapedTab.class).next(value::set);

        SourceCharacterTest.post("\\t");
        assertNotNull(value.get());
    }

}