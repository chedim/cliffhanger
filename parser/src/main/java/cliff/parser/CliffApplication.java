package cliff.parser;

import cliff.ClassNode;

public class CliffApplication extends ClassNode {
    public CliffApplication() {
        an("application location").isA("url");
        an("application result").isA("number");
    }
}
