package cliff.source;

public class PositionTracker {
    private final Position start;
    private int lines, rows, total;

    public PositionTracker(Position start) {
        this.start = start;
    }

    public PositionTracker(String locator) {
        this.start = new Position(locator, 0, 0);
    }

    protected void nextLine() {
        lines++;
        rows = 0;
    }

    protected void nextRow() {
        rows++;
    }

    public PositionTracker advance(char next) {
        if (next == '\n') {
            nextLine();
        } else {
            nextRow();
        }
        total++;
        return this;
    }

    public Position position() {
        return new Position(
                start.locator(),
                start.line() + lines,
                start.row() + rows
        );
    }

    public void reset() {
        lines = 0;
        rows = 0;
        total = 0;
    }
}
