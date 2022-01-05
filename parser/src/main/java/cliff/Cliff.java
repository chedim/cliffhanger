package cliff;

import cliff.lang.CNumber;
import cliff.parser.CliffApplication;
import cliff.parser.CliffParserApplication;
import cliff.source.Phrase;
import com.couchbase.client.java.Cluster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Cliff {
    public static Logger log = LoggerFactory.getLogger(Cliff.class);

    private final DataNode dataGraph = new DataNode();

    private final ClassNode classificationGraph = new ClassNode();

    public Cliff() {
        a("digit").is(CNumber.class);
        a("number").is(new CliffApplication());
    }

    public Reference<DataNode> the(String name) {
        return the(Phrase.parse(name));
    }

    public Reference<DataNode> the(Phrase name) {
        return new DataReference(dataGraph, name);
    }

    public Reference<ClassNode> a(String name) {
        return a(Phrase.parse(name));
    }

    public Reference<ClassNode> a(Phrase name) {
        return new ClassReference(classificationGraph, name);
    }

    public Reference<ClassNode> an(String name) {
        return an(Phrase.parse(name));
    }

    public Reference<ClassNode> an(Phrase name) {
        return new ClassReference(classificationGraph, name);
    }

    public Reference<ClassNode> application(String path) {

    }
}
