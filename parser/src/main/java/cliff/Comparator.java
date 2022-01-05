package cliff;

import java.util.Map;

public final class Comparator {
    private Comparator() {

    }

    public static final class of {
        private of() {

        }

        public static int definitions(Map.Entry<Definition<?>, Condition> e1, Map.Entry<Definition<?>, Condition> e2) {
            int i1 = e1.getValue() != null ? 1 : 0,
                    i2 = e2.getValue() != null ? 1 : 0;
            return i1 - i2;
        }
    }
}
