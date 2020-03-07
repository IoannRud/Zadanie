package interfaces;

import java.util.stream.Stream;

public interface INode {
    String getCode();
    String getRenderer();
    default Stream<INode> getStream(){
        return Stream.of(this);
    }
}
