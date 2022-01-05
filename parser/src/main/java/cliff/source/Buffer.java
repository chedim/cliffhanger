package cliff.source;

import java.io.*;

public class Buffer {

    private InputStream is;

    private StringBuilder buffer = new StringBuilder();
    private int bufferOffset;
    private Position position;
    private PositionTracker attemptPosition;

    public Buffer(InputStream is) {
        this.is = is;
    }

    public int read() throws IOException {
        if (buffer.length() > 0) {
            if (bufferOffset < buffer.length()) {
                return buffer.charAt(bufferOffset++);
            }
        }

        int value = is.read();
        if (value > -1) {
            buffer.append(value);
        } else {
            throw new EOFException();
        }
        return value;
    }

    public void revert() {
        bufferOffset = 0;
        attemptPosition = new PositionTracker(position);
    }

    public void commit() {
        position = attemptPosition.position();
        attemptPosition = new PositionTracker(position);
        buffer.delete(0, bufferOffset);
        bufferOffset = 0;
    }

    public Position position() {
        return attemptPosition.position();
    }

    public void skipWhitespace() throws IOException {
        while (true) {
            int chr = read();
            if (!Character.isWhitespace(chr)) {
                revert();
                break;
            }
            commit();
        }
    }
}
