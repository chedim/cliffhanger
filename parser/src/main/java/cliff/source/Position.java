package cliff.source;

public class Position {
    private final String locator;
    private final int line;
    private final int row;

    @Override
    public String toString() {
        return locator + ":" + line + ":" + row;
    }

    public Position(String locator, int line, int row) {
        this.locator = locator;
        this.line = line;
        this.row = row;
    }

    public String locator() {
        return locator;
    }

    public int line() {
        return line;
    }

    public int row() {
        return row;
    }
}
